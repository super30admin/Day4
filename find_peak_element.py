# Leetcode 162 Find peak element

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = []
        l =0
        r = len(nums) - 1
        while l < r:
            mid = l + (r-l) // 2
            if nums[mid] > nums[mid+1]:
                r = mid 
            elif nums[mid] < nums[mid+1]:
                l = mid+1
           
        return l