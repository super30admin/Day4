//Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
//Space complexity : O(1)
//Time complexity : O(logn)
class Problem1 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int start_index = low;
        int end_index = low;
        if (nums[low] != target)
            return new int[] { -1, -1 };

        high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if (low > start_index)
            end_index = low - 1;

        return new int[] { start_index, end_index };

    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1,2,3 };
        searchRange(arr,2);
    }

}