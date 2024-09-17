#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 21 10:31:11 2019

@author: tanvirkaur
"""
#Time complexity= O(logn)
#Space complexity = O(1)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        low = 0
        high = len(nums)-1
        while(low <= high):
            mid = (low+high) // 2
            if (mid == low or nums[mid-1] < nums[mid]) and( mid == high or nums[mid]>nums[mid+1]):
                return mid
            # we compare if  mid is greater than one of the neighbors and shift our low or high 
            # to that neighnor
            elif mid == high or nums[mid] < nums[mid+1]:
                low = mid+1
            else:
                high = mid-1
        return -1
        
  