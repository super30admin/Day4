//Problem

34. Find First and Last Position of Element in Sorted Array

        Given an array of integers nums sorted in ascending order,find the starting and ending position of a given target value.

        If target is not found in the array,return[-1,-1].

        You must write an algorithm with O(log n)runtime complexity.


// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 need 2 indices and divide the array by doing binary search for finding each indices
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }

    private int binarySearch(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (isFirst) {
                    if (mid == 0 || nums[mid - 1] != target) return mid;
                    else
                        start = mid - 1;
                    end = mid - 1;

                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                    else {
                        start = mid + 1;
                        end = mid + 1;
                    }
                }
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return -1;
    }
}