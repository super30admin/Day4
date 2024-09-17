"""Binary search approach"""
#Accepted on leetcode
#Time complexity - O(logN)
#Space omplexity - O(1)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low + (high - low)//2
            if((mid == low or nums[mid-1]<nums[mid]) and (high == mid or nums[mid]>nums[mid+1])):
                return mid
            if mid == high or nums[mid]<nums[mid+1]:
                low = mid+1
            else:
                high = mid - 1
        return -1