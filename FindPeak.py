"""
Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        # Modified binary search as we increase mid
        # we decrease search space by incrementing the lower bound
        while low < high:
            mid = low + (high - low)//2
            if nums[mid] > nums[mid + 1]:
                high = mid
            else:
                low = mid + 1
        return low