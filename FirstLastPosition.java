/* Description: Performing binary search twice, one for finding first occurence (calculate mid - 
check if mid is the target and the first occurence - return mid, else perform normal binary search in either parts)
and other for last occurence(do same) */
// Time Complexity : O(log n) - performing binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach:
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Base case - if nums is having no integers, return -1,-1
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }
        // Another base case - if target is greater than high element or less than low
        // element,
        // return -1,-1
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] { -1, -1 };
        }
        // Call the BinarySearchFirst for first occurence
        int first = BinarySearchFirst(nums, target);
        // If there is no first occurence, that implies that the target is not present,
        // simply return -1,-1
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        // If not, identify last occurence
        int last = BinarySearchLast(nums, target);
        // Return the indexes
        return new int[] { first, last };

    }

    private int BinarySearchFirst(int[] nums, int target) {
        // Set the low and high value to start binary search
        int low = 0;
        int high = nums.length - 1;
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + ((high - low) / 2);
            // If mid value equal to target, check if it is the first first occurence
            if (nums[mid] == target) {
                // By comparing it with previous element - write check for mid==low incase there
                // is no previous element
                if (mid == low || nums[mid - 1] != target) {
                    // If that is the case, return mid
                    return mid;
                } else {
                    // Else, move to the left and repeat
                    high = mid - 1;
                }
                // If above is not met, check if target is smaller than mid value,
                // In that case move to the left and repeat
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                // Else move right
                low = mid + 1;
            }

        }
        // If not found, return -1
        return -1;
    }

    private int BinarySearchLast(int[] nums, int target) {
        // Set the low and high value to start binary search
        int low = 0;
        int high = nums.length - 1;
        // When low is less than or equal to high, come out of the loop
        while (low <= high) {
            // Calculate the mid in below way to avoid integer overflow exception
            int mid = low + ((high - low) / 2);
            // If mid value equal to target, check if it is the last occurence
            if (nums[mid] == target) {
                // By comparing it with next element - write check for mid==high incase there
                // is no next element
                if (mid == high || nums[mid + 1] != target) {
                    // If that is the case, return mid
                    return mid;
                } else {
                    // Else, move to the right and repeat
                    low = mid + 1;
                }
                // If above is not met, check if target is smaller than mid value,
                // In that case move to the left and repeat
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                // Else move right
                low = mid + 1;
            }

        }
        // If not found, return -1
        return -1;
    }
}