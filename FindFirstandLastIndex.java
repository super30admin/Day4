//Time Complexity: O(logn)
//Space Complexity: O(1)
// Did this code run successfully on leetcode : yes

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] { -1, -1 };
        }

        int first = BinarySearchFirstOccurrence(nums, target);
        if (first == -1) { // element not present
            return new int[] { -1, -1 };
        }
        int last = BinarySearchLastOccurrence(nums, target);

        return new int[] { first, last };

    }

    private int BinarySearchFirstOccurrence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) { // check for first occurence
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;

    }

    private int BinarySearchLastOccurrence(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) { // check for last occurence
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }

        return -1;
    }

}