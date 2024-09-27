// Time Complexity : log(n) + log(n) = O(log(n)) as we are finding target twice using Binary search
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class FirstAndLastPositionOfElement {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findStartingPosition(nums, target);
        result[1] = findEndingPosition(nums, target);
        return result;
    }

    public int findStartingPosition(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }

    public int findEndingPosition(int[] nums, int target) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (nums[mid] == target)
                index = mid;
        }
        return index;
    }
}