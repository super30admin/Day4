// Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Missed few edge cases intially. 

public class problem1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int lower = -1;
        int higher = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid != 0 && nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                } else {
                    lower = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (lower == -1)
            return new int[] { lower, higher };

        low = lower;
        high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid != n - 1 && nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                } else {
                    higher = mid;
                    break;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { lower, higher };
    }
}
