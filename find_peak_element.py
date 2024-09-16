# Time Complexity : log(n)
# Space Complexity : log(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + ((high-low)//2)
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
