/**
 * @author Vishal Puri
 * // Time Complexity : O(logn)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this : No
 */

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] out = new int[]{-1, -1};
        int mid = 0;
        if (nums == null || nums.length == 0) return out;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid - 1 < 0) {
                    out[0] = mid;
                    break;
                } else if (nums[mid - 1] != target) {
                    out[0] = mid;
                    break;
                } else
                    high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        if (out[0] == -1)
            return out;
        for (int i = mid; i < nums.length; i++) {
            if (nums[i] == target) {
                out[1] = i;
            } else
                break;
        }
        return out;
    }

}
