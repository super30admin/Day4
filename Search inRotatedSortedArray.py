#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 15 14:27:18 2019

@author: tanvirkaur
time complexity = O(logn)
"""

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        lo = 0
        n = len(nums)-1
        hi = n
        
        while hi >= lo:
            mid = (lo+hi) // 2
            if nums[mid] == target:
                return mid
            if nums[lo] <= nums[mid]:
                if target >= nums[lo] and target <=  nums[mid]:
                    hi = mid-1
                else:
                    lo = mid+1
            else:
                if target > nums[mid] and target <= nums[hi]:
                    lo = mid+1
                else:
                    hi = mid-1
        return -1