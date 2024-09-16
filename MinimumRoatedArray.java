// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        if(nums.length == 1) return nums[0];

        if(nums.length == 2) {

            return (nums[0] > nums[1])? nums[1]:nums[0];

        }
        //rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

        int left = 0;
        int right = nums.length;

        while(left < right) {

            int mid = left + (right - left)/2;

            // [3,4,5,1,2]
            if(nums[mid] >  nums[mid + 1]) {

                return nums[mid + 1];

            } else if(nums[mid] <  nums[mid + 1]) {

                right = mid;

            }

        }

        if(left != nums.length) {

            return nums[left];

        }

        return -1;
    }
}