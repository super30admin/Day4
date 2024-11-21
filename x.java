/**
 * Modified Binary Search
 *
 * Time Complexity: O(log N)
 *
 * Space Complexity: O(1)
 *
 * N = Length of the input array.
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input is invalid");
        }

        int len = nums.length;
        if (len == 1 || nums[0] < nums[len - 1]) {
            return nums[0];
        }
        if (len == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int start = 0;
        int end = len - 1;

        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return nums[start];
    }
}