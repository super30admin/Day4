# Problem 2: Find Minimum in Rotated Sorted Array

# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Approach:
# 1. Use binary search to find the minimum element in the rotated sorted array.
# 2. If the array is not rotated, return the first element.
# 3. If the array is rotated, find the pivot element where the array is rotated.
# 4. Return the pivot element.

# Note: The min or the pivot element is always in the unsorted part of the array.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            else:
                mid = low + (high - low)//2
                if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                    return nums[mid]
                elif nums[low] <= nums[mid]:
                    low = mid+1
                else:
                    high = mid - 1

        return -1