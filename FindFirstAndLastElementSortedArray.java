// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to go through the lecture again.

/*
 * Boundary conditions: 
 * what if target is outside of the given array range?
 * what if arrays is null or length of array is zero
 * 
 * Approach:
 * We have to do two binary searches 
 * 1. find the start index
 * if(nums[mid-1]==target)
 * 2. fins the end index
 *  (nums[mid+1]==target)
 * 
 */

public class FindFirstAndLastElementSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        int n = nums.length - 1;
        if (target < nums[0] || target > nums[n]) {
            return new int[] { -1, -1 };
        }
        int rightIndex = searchForFirstIndex(nums, target);
        if (rightIndex == -1)
            return new int[] { -1, -1 };
        int leftIndex = searchForLastindex(nums, target);

        return new int[] { rightIndex, leftIndex };

    }

    public int searchForFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == left || nums[mid - 1] != nums[mid]) {
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

    public int searchForLastindex(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {

                if (mid == right || nums[mid] != nums[mid + 1]) {
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
