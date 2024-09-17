// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    private int getStart(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
             
                if (mid == 0 || nums[mid-1] != target) {
                    return mid;
                }
                else {
                    end = mid - 1;
                }
            }
            else if (target < nums[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    private int getEnd(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        
        if (start == -1) {
            return -1;
        }
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
             
                if (mid == nums.length - 1 || nums[mid+1] != target) {
                    return mid;
                }
                else {
                    start = mid + 1;
                }
            }
            else if (target < nums[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int startIndex = getStart(nums, target);
        int endIndex = getEnd(nums, target);
        
        return new int[]{startIndex, endIndex};
    }
}
