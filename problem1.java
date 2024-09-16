// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        
        int left = leftBinarySearch(nums, target);   // find index of the left most occurence of the target
        if(left == -1) return new int[]{-1, -1};     // if target is not present
        int right = rightBinarySearch(nums, target); // find index of the right most occurence of the target
        return new int[] {left, right};
    }
    
    private int leftBinarySearch(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)  {
                if(mid == low || nums[mid-1] < nums[mid]) //check if it is a left most occurence
                    return mid;
                else                            // continue checking left
                    high = mid - 1;
                
            } else if(nums[mid] > target) 
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    
    private int rightBinarySearch(int[] nums, int target) {
        
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)  {
                if((mid == nums.length - 1) || nums[mid + 1] > nums[mid]) //check if it is a right most occurence
                    return mid;
                else                            // continue checking right
                    low = mid + 1;
                
            } else if(nums[mid] > target) 
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

}