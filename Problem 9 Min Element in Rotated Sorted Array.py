# Time Complexity: O(log(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Logic: perform binary search & compare mid element with left & right, if smaller than both return the element

import sys


class Solution:
    def findMin(self, nums):
        start = 0
        end = len(nums) - 1
        while start <= end:
            if nums[start] < nums[end]:
                return nums[start]
            mid = start + (end - start) // 2
            right = left = sys.maxsize
            if mid - 1 >= start:
                left = nums[mid - 1]
            if mid + 1 <= end:
                right = nums[mid + 1]
            if nums[mid] < left and nums[mid] < right:
                return nums[mid]
            if nums[mid] > nums[start]:
                start = mid + 1
            else:
                end = mid - 1


sol = Solution()
print(sol.findMin([4, 5, 6, 7, 0, 1, 2]))
print(sol.findMin([]))
