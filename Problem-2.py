## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
"""
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


// Time Complexity :  O(logn)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : the while loop condition
"""


def Solution(nums):
    low = 0
    high = len(nums) - 1
    while low < high:  # we want to break out of the while loop as we always have a valid answer so we check jus low < high
        mid = low + (high - low) // 2
        # element before and after nums[mid] is greater than element at mid, means nums[mid] is smallest element
        # mid==0 will take care if we have mid at 0 position
        if (mid == 0 or (nums[mid] < nums[mid - 1])) and nums[mid] < nums[mid + 1]:
            return nums[mid]
        elif nums[low] < nums[high]:      # array is sorted and not rotated, low is smallest element
            return nums[low]
        elif nums[mid] > nums[high]:      # nums[mid] > nums[high] move to the right side
            low = mid + 1
        else:                              # nums[low] > nums[mid] move to the left side
            high = mid - 1
    return nums[low]                        # or return nums[high]  when low and high at same element

print(Solution([4,5,6,7,-1,1,2]))







