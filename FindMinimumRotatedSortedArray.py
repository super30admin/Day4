# -*- coding: utf-8 -*-
"""
Created on Tue Feb  4 21:13:32 2020

@author: WELCOME
"""
"""
Find Min element in rotated sorted array
Time - O(logN)
Space - O(1)
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if ((mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            if nums[mid]<nums[high]:
                high=mid-1
            else:
                low=mid+1
        