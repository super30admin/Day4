# Approach:
# We perform binary search twice: first to find the leftmost index (first occurrence) 
# and second to find the rightmost index (last occurrence) of the target. 
# If the target is not present, both searches will return -1. This approach guarantees 
# O(log n) time complexity by utilizing binary search instead of linear traversal.

# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findLeft(nums, target):
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1  # Continue searching left part
            return left

        def findRight(nums, target):
            left, right = 0, len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] <= target:
                    left = mid + 1  # Continue searching right part
                else:
                    right = mid - 1
            return right

        # Find the leftmost and rightmost positions
        left_index = findLeft(nums, target)
        right_index = findRight(nums, target)

        # Check if the target is not found
        if left_index <= right_index and right_index < len(nums) and nums[left_index] == target:
            return [left_index, right_index]
        else:
            return [-1, -1]
