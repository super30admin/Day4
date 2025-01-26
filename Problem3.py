# Problem 3: Find Peak Element
# Time Complexity: O(log n)
# Space Complexity: O(1)

# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Approach:
# 1. Use binary search to find the peak element in the array.
# 2. If the array is not rotated, return the first element.
# 3. If the array is rotated, find the pivot element where the array is rotated.
# 4. Return the pivot element.

# Note: Moving towards the greater element in the array or towards the rising slope will always lead to the peak element. But moving towards the smaller element in the array or towards the falling slope will always lead to the valley element.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l,h = 0, n-1

        while l<=h:
            m = l + (h-l)//2
            if (m == 0 or nums[m] > nums[m-1]) and (m == n-1 or nums[m] > nums[m+1]):
                return m
            elif nums[m] < nums[m+1]:
                l = m + 1
            else:
                h = m - 1
        return -1
