// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n-1;

        while (low<=high) {
            int mid = low + (high - low)/2; // prevent integer overflow
            if (nums.length == 1) {
                return 0;
            }

            if ((mid == low || nums[mid] > nums[mid-1]) && (mid == high || nums[mid] > nums[mid+1])) {
                return mid;
            } else if (mid == n-1 || nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}