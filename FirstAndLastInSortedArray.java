class Solution {

    private int binarySearchOnRight(int[] nums, int target, int lo) {

        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // Two cases if mid is equal to target
            // 1. There must be no elements on the right with same value as mid. If it is
            // true return mid.
            // 2. There must be one or more elements on the right with the same value as
            // mid. In that case move the lo value to mid + 1.

            if (nums[mid] == target) {
                // Always check if the mid element reaches the last element When comparing mid
                // with elements to its right side.
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }

            else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;

        }
        return -1;
    }

    private int binarySearchOnLeft(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // Two cases if mid is equal to target
            // 1. There must be no elements on the left with same value as mid. If it is
            // true return mid.
            // 2. There must be one or more elements on the left with the same value as mid.
            // In that case move the hi value to mid - 1.
            if (nums[mid] == target) {
                // Always check if the mid element reaches the first element When comparing mid
                // with elements to its left side.
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    hi = mid - 1;
                }
            }

            else if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;

        }
        return -1;
    }

    // TC - O(logn)
    // SC - o(1)
    public int[] FirstAndLastInSortedArray(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        if (nums.length == 1 && nums[0] == target) {
            return new int[] { 0, 0 };
        }

        int leftmost = binarySearchOnLeft(nums, target);

        if (leftmost == -1) {
            return new int[] { -1, -1 };
        }

        int rightmost = binarySearchOnRight(nums, target, leftmost);

        return new int[] { leftmost, rightmost };

    }
}