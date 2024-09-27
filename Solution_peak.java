/*
Time Complexity :  log(n) 
Space Complexity :  O(1)
Leetcode : Yes, all test cases passed
*/

class Solution {
    public int findPeakElement(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            // checking edge cases

            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }

            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}