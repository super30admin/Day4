// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 0) {
            return -1;
        } // no need for edge case, but writing cause of habit
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) { // array is sorted
                return nums[low];
            }
            int middle = low + (high - low) / 2;
            if ((middle == 0 || nums[middle] < nums[middle - 1]) // check to see if middle element is the smallest
                    && (middle == nums.length - 1 || nums[middle + 1] > nums[middle])) {
                return nums[middle];
            }

            if (nums[low] <= nums[middle]) { // left side is sorted, move left
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}