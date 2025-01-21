"""

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Time Complexity : O(LogN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# This solution uses binary search twice to find the first and last positions of the target in a sorted array.  
# The first binary search (leftBias=True) finds the leftmost index, while the second (leftBias=False) finds the rightmost index.  
# If the target is not found, both searches return -1, otherwise, they return the range [left, right].  


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = self.binarySearch(nums, target, True)
        right = self.binarySearch(nums, target, False)

        return [left, right]

    def binarySearch(self, nums, target, leftBias):
        l, r = 0, len(nums) - 1
        i = -1

        while l <= r:
            mid = l + ((r - l) // 2)

            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                i = mid
                if leftBias:
                    r = mid - 1
                else:
                    l = mid + 1

        return i
