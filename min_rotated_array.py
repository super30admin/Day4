#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 31 15:37:38 2021

@author: ameeshas11
"""

#Time Complexity : O(log n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if (len(nums)==0):
            return -1
        minimum = nums[0]
        low = 0
        high = len(nums) - 1
        
        while high >= low:
            mid = (low + high)//2
            #if there is only one number return that or if the whole array is sorted return first element
            if nums[low]<=nums[high]:
                return nums[low]
            #if lowest is found return that
            if nums[mid-1] > nums[mid] and nums[mid+1]>nums[mid]:
                return nums[mid]
            #move to the unsorted side
            if nums[low]<=nums[mid]:
                low = mid+1
            else:
                high = mid-1
                    
        return -1