// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
public class FirstandLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int start = startIndex(nums, target);

        if (start == -1)
            return new int[] { -1, -1 };

        return new int[] { start, lastIndex(nums, target) };

    }

    public int startIndex(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid > 0 && nums[mid - 1] == target) {
                    high = mid - 1;
                } else {
                    return mid;
                }

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;

    }

    public int lastIndex(int[] nums, int target) {

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid < nums.length - 1 && nums[mid + 1] == target) {
                    low = mid + 1;
                } else {
                    return mid;
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
