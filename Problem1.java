// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 2 methods to find element in first half and second half
        int i = findFirst(nums, target);
        int j = findLast(nums, target);
        return new int[] {i, j};
    }

    public static int findFirst(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;
        // here we take >= because of duplicate values
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }

    public static int findLast(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;
        // here we take <= because of duplicate values
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}