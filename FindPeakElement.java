// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;

        int l = 0;
        int h = nums.length - 1;

        while(l<=h) {
            int mid = l+(h-l)/2;

            if((mid == l || nums[mid-1] < nums[mid]) && (mid == h || nums[mid+1] < nums[mid])) {
                return mid;
            } else if(nums[mid+1] > nums[mid]){
                l = mid+1;
            } else{
                h = mid - 1;
            }
        }
        return -1;
    }
}