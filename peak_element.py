#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 31 15:47:53 2021

@author: ameeshas11
"""
#Time Complexity : O(log n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        
        low = 0
        high = len(nums)-1
        
        while high>=low:
            
            mid = (low+high)//2
            
            #if the element is peak 
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            
            elif nums[mid+1]>nums[mid]:
                low = mid+1
            else:
                high = mid-1