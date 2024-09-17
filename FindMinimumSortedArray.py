#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 15 14:28:41 2019

@author: tanvirkaur
ime complexity = O(logn)
"""

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        lo = 0
        n = len(nums)-1
        hi = n
        while hi>=lo :
            mid = lo+(hi-lo) // 2
            if mid < n and nums[mid+1] < nums[mid]:
                return nums[mid+1]
            if mid < n and nums[mid] < nums[mid-1]:
                return nums[mid]
            if nums[lo] < nums[mid]:
                lo = mid +1
            else:
                hi = mid -1
        return nums[0]