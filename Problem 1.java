// Problem 1: Find first and last position of element in sorted array

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    public int binarySearchLeft(int[] nums, int target) {
        
        int low = 0; int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid -1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int binarySearchRight(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == high || nums[mid + 1] > nums[mid]) {
                    return mid;
                } else {
                    low = mid +1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
                
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        //Edge case
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        return new int[] {binarySearchLeft(nums, target), binarySearchRight(nums, target)};
        
    }
}