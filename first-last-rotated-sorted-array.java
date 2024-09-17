//Time complexity is Log(n)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int first = findFirstElement(nums, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }

        int last = findLastElement(nums, target);

        return new int[] { first, last };
    }

    private int findFirstElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        System.out.println("I am here");
        while (low <= high) {
            int mid = low + (high - low) / 2; // prevent integer overflow

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
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

    private int findLastElement(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // prevent integer overflow

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
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
}