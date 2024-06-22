// Time Complexity : O(Logn) - Binary Search
// Space Complexity :O(1) - No extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//In first pass of binary search we try finding first position-> if we get mid as target we check if its the first position, if not then again search in left side of array
//repeat until mid is not the first occurrence

//In second pass of binary search we try finding last position-> if we get mid as target we check if its the last position, if not then again search in right side of array
//repeat until mid is not the last occurrence

class Solution {

    // Helper method to find the first position of the target in the array
    private int firstPosition(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid index
            if (nums[mid] == target) {
                // Check if it's the first occurrence
                if (mid == 0 || nums[mid] != nums[mid - 1])
                    return mid; // Return the first position
                else {
                    high = mid - 1; // Move left to find the first occurrence
                }
            } else if (nums[mid] > target)
                high = mid - 1; // Move left if target is smaller
            else {
                low = mid + 1; // Move right if target is larger
            }
        }
        return -1; // Return -1 if target is not found
    }

    // Helper method to find the last position of the target in the array
    private int lastPosition(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate the mid index
            if (nums[mid] == target) {
                // Check if it's the last occurrence
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1])
                    return mid; // Return the last position
                else {
                    low = mid + 1; // Move right to find the last occurrence
                }
            } else if (nums[mid] > target)
                high = mid - 1; // Move left if target is smaller
            else {
                low = mid + 1; // Move right if target is larger
            }
        }
        return -1; // Return -1 if target is not found
    }

    // Main method to find the range of target in the array
    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 }; // Initialize result array with -1s
        if (firstPosition(nums, target, 0, nums.length - 1) == -1)
            return result; // Return if target is not found in the array
        result[0] = firstPosition(nums, target, 0, nums.length - 1); // Find first position
        result[1] = lastPosition(nums, target, result[0], nums.length - 1); // Find last position
        return result; // Return the range
    }
}
