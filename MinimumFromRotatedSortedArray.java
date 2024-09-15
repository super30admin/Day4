// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            mid = low + (high-low)/2;

            // check if mid is the minimum
            if((mid == low || nums[mid-1] > nums[mid]) && (mid == high || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            }

            if (nums[mid]  >= nums[low]) {
                // left side is sorted, go to right side to find minimum element
                if(nums[low] < nums[high]) return nums[low];
                low = mid + 1;
            } else {
                // right side is sorted, go to left side to find minimum element
                high = mid;
            }
        }
        return -1;
    }
}