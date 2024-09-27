# -*- coding: utf-8 -*-
"""
Created on Mon Aug 23 19:17:38 2021

@author: amido
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums)-1
        print(l,h)
        
        #size of array is 1, thats the peak
        if h==0:
            print("first if ",h)   
            return h
        
        #checking boundary
        if nums[l] > nums[l+1]:
            print("first element ",l)   
            return l
        #if nums[h] < nums[h-1]:
        #print("last element ",nums[h])   
          #  return h
        
        
        while(l<=h):
            mid = int((l+h)/2)
            
            print(l,mid,h)
            if (mid == 0 or (nums[mid-1] < nums[mid])) and (mid == (len(nums)-1) or nums[mid] > nums[mid+1]):
                return mid
            
            if(nums[mid] > nums[mid+1]):
                h = mid -1
            else:
                l = mid + 1
                