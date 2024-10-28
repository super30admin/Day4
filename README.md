# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Approach: Perform binary search twice to find the starting and ending position of an element in an array

Time Complexity: O(logn)
Space Complexity: O(1)

class Solution {
public int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        int[] result = new int[]{-1, -1};
        if(n == 0) return result;

        int first = binarySearchFirst(nums, target, 0, n - 1);

        if(first == - 1) return result; 

        int last = binarySearchLast(nums, target, first, n - 1);

        return new int[]{first, last};
    }

    private int binarySearchFirst(int[] nums, int target, int low, int high) {

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {

                if(mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int low, int high) {

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {

                if(mid == high || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0

Approach: Perform binary search on the unsorted side of the array to find the minimum element

Time Complexity: O(logn)
Space Complexity: O(1)

class Solution {
public int findMin(int[] nums) {

        int n = nums.length;
        if(n == 0) return -1;
        
        int low = 0, high = n - 1;

        while(low <= high) {

            // check for sorted array
            if(nums[low] <= nums[high]) {
                return nums[low];
            }

            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid - 1] > nums[mid]) 
            && (mid == n - 1 || nums[mid + 1] > nums[mid])) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) {
                // minimum element will be present on the unsorted side always
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.

Approach: Perform binary search on the greater element side to find the peak.

Time Complexity: O(logn)
Space Complexity: O(1)

class Solution {
public int findPeakElement(int[] nums) {
if(nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
             } else if(mid > 0 && nums[mid] < nums[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
