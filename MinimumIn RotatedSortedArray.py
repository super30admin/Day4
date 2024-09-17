#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Nov 21 08:59:21 2019

@author: tanvirkaur
"""

# Time complexity = O(logn)
# space complexity = O(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums)-1
        while(low<= high):
            if nums[low] < nums[high]:
                return nums[low]
            mid = (low + high) //2
            # checking the conditions for minimum element 
            if (low == mid or nums[mid-1] > nums[mid]) and (mid == high or nums[mid+1]> nums[mid]):
                return nums[mid]
            #the part that is sorted move to the opposite side 
            elif nums[low] <= nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return -1