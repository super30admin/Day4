//Problem1

public class FirstAndLastPosition {
    class Solution {

        private int left1;

        private int BinarySearchFirst(int[] nums, int target) {

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {

                    if (mid == 0 || nums[mid] > nums[mid - 1]) {
                        left1 = mid;
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

        private int BinarySearchLast(int[] nums, int target) {

            int low = left1;
            int high = nums.length - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (nums[mid] == target) {

                    if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
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

        public int[] searchRange(int[] nums, int target) {

            // edge case
            if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
                return new int[] { -1, -1 };

            int first = BinarySearchFirst(nums, target);
            if (first == -1)
                return new int[] { -1, -1 };
            int last = BinarySearchLast(nums, target);
            return new int[] { first, last };

        }
    }
}
