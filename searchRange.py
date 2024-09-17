#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct 14 10:49:05 2019

@author: tanvirkaur
"""

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
 
         """
        
        def first(nums,low,high,target):
            while low <= high:
                mid =  low+(high-low)//2
                if nums[mid] == target:
                    if mid == low or nums[mid-1] < target:
                        return mid
                    high = mid -1
                else:
                    if nums[mid] > target:
                        high = mid -1
                    else:
                        low = mid+1
            return -1
        def last(nums,low,high,target):
            while low<= high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    if mid ==high or nums[mid+1] > target:
                        return mid
                    low = mid+1
                else:
                    if nums[mid] > target:
                        high = mid -1
                    else:
                        low = mid+1
            return -1
        left = first(nums,0,len(nums)-1,target)
        right = last(nums,0,len(nums)-1,target)
        return(left,right) 