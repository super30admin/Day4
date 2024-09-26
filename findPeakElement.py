# Time Complexity O(logn)
#Space Complexity O(1)
#Executed on Leetcode
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        h = len(nums)-1
        while l <= h:
            mid = l + (h-l)/2
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid+1] < nums[mid]):
                return mid
            elif (mid > 0 and nums[mid] < nums[mid-1]): h = mid-1
            else: l = mid + 1
