// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0) return -1;

        int l = 0;
        int h = nums.length - 1;

        while(l<=h) {
            int m = l+(h-l)/2;

            //check if lowest is smallest.
            if(nums[l] <= nums[h]) {
                return nums[l];
            }

            //check if mid is smallest by comparing to immediate left and right
            if((m == l || nums[m-1] > nums[m]) && (m == h ||nums[m+1] > nums[m])) {
                return nums[m];
            }

            if(nums[l] <= nums[m]) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        return -1;
    }
}