# -*- coding: utf-8 -*-
"""
Created on Tue Feb  4 22:05:16 2020

@author: WELCOME
"""
"""
Working on Leetcode
First and last occurence of sorted array
Time-O(logN)
Space - O(`1)
"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearch():
            low=0
            high=len(nums)-1
            while(low<=high):
                mid=(low+high)//2
                if nums[mid]==target:
                    return mid
                elif nums[mid]>target:
                    high=mid-1
                else:
                    low=mid+1
            return -1
        index=binarySearch()
        def searchRight(index):
            if index==-1:
                return -1
            low=index
            high=len(nums)-1
            while(low<=high):
                mid=(low+high)//2
                if nums[mid]==target:
                    if mid==len(nums)-1 or nums[mid]<nums[mid+1]:
                    
                        return mid
                
                if nums[low]==nums[mid]:
                    low=mid+1
                else:
                    high=mid-1
            return -1
        def searchLeft(index):
            if index==-1:
                return -1
            low=0
            high=index
            while(low<=high):
                mid=(low+high)//2
                if nums[mid]==target:
                    if mid==0 or nums[mid]>nums[mid-1]:
                    
                        return mid
                
                if nums[high]==nums[mid]:
                    high=mid-1
                else:
                    low=mid+1

        temp=[]
        temp.append(searchLeft(index))
        temp.append(searchRight(index))
        return temp