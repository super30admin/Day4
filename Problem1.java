// Time Complexity
// With bruteforce solution: O(n^2)
// With Binary search Optimization: O(Log n)
// Where n = number of elements in array.
// Space Complexity
// With bruteforce solution: O(1)
// With Binary search Optimization: O(1)

class Solution {
    int first;

    private int binarySearchLeft(int nums[], int low, int high, int target) { // Normal binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid]) { // Condition to divide search space by half
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

    private int binarySearchRight(int nums[], int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] > target) { // Condition to divide search space by half
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
        if (nums == null || nums.length == 0) { // Null condition
            return new int[] { -1, -1 }; // So return array of -1, -1.
        }
        if (nums[0] > target || nums[nums.length - 1] < target) { // Check for sorted array and target out of given
                                                                  // range
            return new int[] { -1, -1 }; // So return array of -1, -1.
        }

        first = binarySearchLeft(nums, 0, nums.length - 1, target); // Check the array for first position of target
        if (first == -1) // if first position not found then the target not available in nums
            return new int[] { -1, -1 }; // So return array of -1, -1.

        int last = binarySearchRight(nums, first, nums.length - 1, target); // Check the array for last position of
                                                                            // target setting first position index as
                                                                            // low

        return new int[] { first, last }; // return first and last index in an array
    }
}