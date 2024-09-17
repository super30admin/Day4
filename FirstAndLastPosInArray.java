/**
Problem: Find first and last position of an element in an array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[] {-1, -1};
        }

        int first = binarySearchForFirstNumber(nums, target);
        if (first == -1) {
            return new int[] {-1, -1};
        }

        int second = binarySearchForSecondNumber(nums, target);
        return new int[] {first, second};
    }

    public int binarySearchForFirstNumber(int nums[], int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
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

    public int binarySearchForSecondNumber(int nums[], int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
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