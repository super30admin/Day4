// Time Complexity: O(log N)
// Space Complexity: O(1)

public class Solution {
    private int BinarySearchFirst(int[] nums, int low, int high, int target) {
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

    private int BinarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] SearchRange(int[] nums, int target) {
        int n = nums.Length;
        if (nums == null || nums.Length == 0) return new int[] { -1, -1 };
        if (target < nums[0] || target > nums[n - 1]) return new int[] { -1, -1 };

        int first = BinarySearchFirst(nums, 0, n - 1, target);
        if (first == -1) return new int[] { -1, -1 };

        int last = BinarySearchLast(nums, first, n - 1, target);
        return new int[] { first, last };
    }
}
