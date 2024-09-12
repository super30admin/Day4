# Time Complexity: O(logn)
# Space Complexity: O(nums)
# Did this code successfully run on Leetcode: all test cases passed
# Any problem you faced while coding this: No

class Solution:
    def findPeakElement(self, nums):
        lo, hi = 0, len(nums) - 1
        while lo < hi:
            mid = lo + hi >> 1
            if nums[mid] > nums[mid+1]: hi = mid
            else: lo = mid + 1
        return lo