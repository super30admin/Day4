// Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding: Faced issue when trying to find minimum at end of array 



class Solution {
    public int findMin(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        
        int low = 0;
        int high = nums.length-1;
        if (nums[high]>nums[0]){
            return nums[0];
        }
        while (low<=high){
            int mid = low + (high-low)/2;
            if (nums[mid+1]<nums[mid]){
                return nums[mid+1];
            }
            if (nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            
            if (nums[mid]> nums[0]){
                low = mid+1;
            }
            else {
                high = mid-1;
            }
            
        }
        return -1;
    }
}