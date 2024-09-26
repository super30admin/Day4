// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[] {-1, -1};
        // if number is not within the range return -1,-1
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};
        
        int first = binarySearchFirstOccurence(nums, target);
        if(first == -1) return new int[] {-1, -1};
        int last = binarySearchLastOccurence(nums, target);
        
        return new int[] {first, last};
    }
    
    private int binarySearchFirstOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target) {
                // check if left element is smaller than mid
                if(mid == 0 || nums[mid - 1] < nums[mid]) 
                    return mid;
                else high = mid - 1;
            }
            // if target is smaller then move to the left side
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            // if target is greater then move to right side
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    private int binarySearchLastOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                // check if right element if greater than mid
                if(mid == nums.length - 1 || nums[mid + 1] > nums[mid]) 
                    return mid;
                else low = mid + 1;
            }
            // if target is smaller then move to the left side
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            // if target is greater then move to right side
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}