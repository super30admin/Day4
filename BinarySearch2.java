// Problem 1 : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
class Solution {

    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
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

    private int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] < nums[mid + 1]) {
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
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        int n = nums.length;
        int first = binarySearchFirst(nums, 0, n - 1, target);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        int last = binarySearchLast(nums, first, n - 1, target);
        return new int[] { first, last };

    }
}

// Problem 2
// :https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return 123;
    }
}

// Problem 3: https://leetcode.com/problems/find-peak-element/description/
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == high || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}