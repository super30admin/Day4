# -*- coding: utf-8 -*-
"""
Created on Sat Aug 21 18:58:55 2021

@author: User
"""

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if (len(nums)==0):
            return -1
        low=0
        high=len(nums)-1
        if(nums[low]<nums[high]):
                return nums[low]
        while(low<=high):
            if(nums[low]<nums[high]):
                return nums[low]
            mid=int(low+(high-low)/2)
            if ((mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            elif(nums[low]<=nums[mid]):
                low=mid+1
            else:
                high=mid-1
        return 1121
                    