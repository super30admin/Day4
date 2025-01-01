# Time Complexity : 0(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
class Solution:
    def findMin(self, nums) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        low = 0
        high = n -1
        while low <= high:
            mid = low + ((high - low)//2)
            if nums[low] <= nums[high]:
                return nums[low]
            if mid >= 0 and nums[mid] < nums[mid - 1]:
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid +1
            else:
                high = mid -1
        