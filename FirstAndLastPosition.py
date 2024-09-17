#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 21 08:58:50 2019

@author: tanvirkaur
"""

# Time complexity = O(logn)
# Space complexity = O(1)
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
 
         """
        
        def lowestIndex(nums,target,low,high):
            while(low<= high):
                mid = (high+low)//2
                #if we find our targert we will check it meets the conditions of lowest index,if yes return mid else shift the high pointer and again perform the binary search 
                if nums[mid] == target:
                    if(mid == low or nums[mid-1] < nums[mid]):
                        return mid
                    else:
                        high = mid-1
                elif nums[mid] < target:
                    low = mid +1
                else:
                    high = mid-1
            return -1
        
        def HighestIndex(nums,target,low,high):
            while(low<= high):
                mid = (high+low)//2
                if nums[mid] == target:
                    if(mid == high or nums[mid+1] > nums[mid]):
                        return mid
                    else:
                        low = mid+1
                elif nums[mid] < target:
                    low = mid +1
                else:
                    high = mid-1
            return -1
        left = lowestIndex(nums,target,0, len(nums)-1)
        right = HighestIndex(nums,target,0,len(nums)-1)
        return (left,right)
        