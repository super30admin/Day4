"""
Time Complexity:    O(log(n))
Space Complexity:   O(1)
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am using binary search to search the peak value
the catch here is to always go in the direction of the highest element
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return None
        if len(nums) == 1:
            return 0
        lo, hi = 0, len(nums)-1
        while lo<=hi:
            mid = lo + (hi-lo)//2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums) -1 or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid] > nums[mid+1]:
                hi = mid - 1
            else:
                lo = mid + 1
        return -1