// Time complexity: O(logN) + O(N) + O(N) ~ O(N) can be improved further
// Space complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : tracking the old and new min value

public class FindFirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                low = mid;
                high = mid;
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low > high) {
            return new int[]{-1, -1};
        }

        while (low >= 0) {
            if (nums[low] != target)
                break;
            low--;
        }

        while (high <= nums.length - 1) {
            if (nums[high] != target)
                break;
            high++;
        }

        return new int[]{low + 1, high - 1};
    }
}
