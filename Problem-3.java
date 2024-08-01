// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to go over the recording to understand the logic.

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0; 
        int high = nums.length - 1;
        int n = high;
        // int mid;

        while (low <= high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] > nums[mid - 1]) 
            && ( mid == n || nums[mid] > nums[mid + 1])){
                return mid;
            }

            if(mid > 0 && nums[mid - 1] > nums[mid]){
                high = mid -1 ;
            }else{
                low = mid + 1;
            }
        }

        return - 1;
    }
}