// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        if (nums == null || n == 0)
            return new int[] { -1, -1 };
        if (target < nums[0] || target > nums[n - 1])
            return new int[] { -1, -1 };
        int firstIndex = binarySearchFirst(nums, low, high, target);
        if (firstIndex == -1)
            return new int[] { -1, -1 };
        int lastIndex = binarySearchLast(nums, firstIndex, high, target);
        return new int[] { firstIndex, lastIndex };
    }

    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}