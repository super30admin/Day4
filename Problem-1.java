// Time Complexity : O(log N)
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] { -1, -1 };
        int left = findLeftMostIndex(nums, target);

        if (left == -1)
            return new int[] { -1, -1 };

        int right = findRightMostIndex(nums, target);

        return new int[] { left, right };
    }

    private int findLeftMostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftMostIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                leftMostIndex = mid;
                right = mid - 1;
            }
        }
        return leftMostIndex;
    }

    private int findRightMostIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightMostIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                rightMostIndex = mid;
                left = mid + 1;
            }
        }
        return rightMostIndex;
    }

}