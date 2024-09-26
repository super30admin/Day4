#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug 31 15:17:29 2021

@author: ameeshas11
"""
#Time Complexity : O(log n)
#Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        #initialise low and high
        l = 0
        h = len(nums)-1
        first = last = -1
        
        #find first index
        while (l<=h):
            m = (l+h)//2
            
            #if target if found
            if ( nums[m] == target):
                #check if its the lowest index
                if m == 0 or nums[m-1]<target:
                    first = m
                    break
                #find lowest index
                else:
                    h = m-1
            elif nums[m]>target:
                h = m-1
            else:
                l = m+1
        
        l = first + 1
        last = first
        h = len(nums)-1
        
        #if target exists in array find last index
        if first != -1:
            while (l<=h):
                m = (l+h)//2
                #when target found
                if (nums[m] == target):
                    #check if its the max index
                    if m == len(nums)-1 or nums[m+1]>target:
                        last = m
                        break
                    #find max index
                    else:
                        l = m+1
                elif nums[m]>target:
                    h = m-1
                else:
                    l = m+1
                
        return [first, last]