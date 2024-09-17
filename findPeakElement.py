#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 15 14:30:04 2019

@author: tanvirkaur
"""

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        lo = 0
        hi = len(nums)-1
        while lo<= hi:
            mid = (lo + hi)/2
            if lo == hi or nums[mid] > max(nums[mid+1] ,nums[mid-1]):
                return mid
            if nums[mid+1] > nums[mid]:
                lo = mid+1
            else:
                hi = mid-1
        return -1
            