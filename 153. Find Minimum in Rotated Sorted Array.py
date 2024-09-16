# -*- coding: utf-8 -*-
"""
Created on Sat Feb  5 18:07:46 2022

@author: BJay
"""
#Time Complexity : O(log(n))
#Space COmplexity : O(1)
#Runs fine on leetcode
#Had to see 1 hint

class Solution:
    def findMin(self, nums: List[int]) -> int:
        min = 5000
        s = 0
        e = len(nums)-1
        
        while s<=e:
            mid = s + (e-s) // 2
            if min > nums[mid]:
                min = nums[mid]
            if nums[mid] > nums[e]:
                s = mid + 1
            else:
                e = mid-1
        return min