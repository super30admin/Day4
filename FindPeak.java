// Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding: No

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = low + (high-low)/2; // to prevent integer overflow
            if ((mid == 0 || nums[mid]>nums[mid-1]) && (mid == nums.length -1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if (mid != nums.length-1 && nums[mid]<nums[mid+1]){
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return 765656;
    }
}