package Binary-Search-2;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        // if given array is empty
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }

        // if the target value is less that nums[0] and
        // greater than nums[nums.length -1]
        // then target value is not in the array
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return new int[] { -1, -1 };
        }

        int first = BSFirst(nums, target);
        int last = BSLast(nums, target);

        return new int[] { first, last };
    }

    private int BSFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }

    private int BSLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }
}

// Time Complexity: O(logn)
// Space Complexity: O(1)
//Problem was working on leetcode