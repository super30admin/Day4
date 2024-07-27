// Problem 34: Find First and Last Position of Element in Sorted Array
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class firstLastElemetSortedArray {
    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                }
                high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                }
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0 || nums[0] > target || nums[len - 1] < target) {
            return new int[]{-1, -1};
        }

        int first = binarySearchFirst(nums, 0, len - 1, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = binarySearchLast(nums, first, len - 1, target);
        return new int[]{first, last};
    }
}
