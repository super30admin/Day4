// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        
        int length = nums.length-1;
        
        if (nums[0] > target || nums[length] < target) return new int[] {-1, -1};
        
        int firstIndex = getFirstIndex(nums, target);
        
        if (firstIndex != -1) {
            int lastIndex = getLastIndex(nums, target, firstIndex, length);
            
            return new int[] {firstIndex, lastIndex};
        }
        
        return new int[] {-1, -1};
    }
    
    private int getFirstIndex(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                } else { // check in left half of array
                    end = mid - 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
    
    private int getLastIndex(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end-start)/2;
            
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid] < nums[mid+1]) {
                    return mid;
                } else { // check in right half of array
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}