// Time Complexity :O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class FindFirstAndLastPositionOfElementInSortedArray {

    private int findFirstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                //  check if mid is the first index
                if (mid == 0 || nums[mid - 1] != nums[mid])
                    return mid;
                else    // keep moving left
                    high = mid - 1;
            }
            else {
                if (target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return -1;
    }

    private int findLastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                //  check if mid is the last index
                if (mid == nums.length - 1 || nums[mid + 1] != nums[mid])
                    return mid;
                else    // keep moving right
                    low = mid + 1;
            }
            else {
                if (target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        if (target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};

        int first = findFirstIndex(nums, target);
        int last = findLastIndex(nums, target);

        return new int[]{first, last};
    }
}