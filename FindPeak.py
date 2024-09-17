"""
The Idea here is simple, find the mid and check if mid > mid+1 then
it is a decesending slope hence we need to move to the left. if not
it is a ascending slope and hence we need to move to the right of the
array.
"""

class Solution(object):
    def findPeakElement(self, nums):
        low = 0
        high = len(nums) - 1
        while(low<high):
            mid = low + (high-low) / 2
            if nums[mid] > nums[mid+1]:
                high = mid
            else:
                low = mid + 1
        return low
