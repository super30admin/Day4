# Time Complexity : 0(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) -1 
        while low <= high:
            mid = low + (high - low )//2

            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid

            elif nums[mid + 1] > nums[mid]:
                low = mid +1
            else:
                high = mid - 1