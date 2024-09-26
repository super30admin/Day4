// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// I would apply binary search twice. In the first call, I can return the leftmost index of the target value.
// In the second one, I would return the last index of the target. If the target is not present, I would return -1.

public class FindFirstAndLast {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int lowIndex = getLowerIndex(nums, target, 0, nums.length - 1);
        if (lowIndex == -1) return new int[]{-1, -1};

        int highIndex = getHigherIndex(nums, target, lowIndex, nums.length - 1);

        return new int[]{lowIndex, highIndex};
    }

    private int getLowerIndex(int[] nums, int target, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                high = mid - 1;

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    private int getHigherIndex(int[] nums, int target, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                index = mid;
                low = mid + 1;

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
