# -*- coding: utf-8 -*-
"""
Created on Sun Aug 22 15:02:59 2021

@author: User
"""

class Solution(object):
    global first_index

    def searchRange(nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """   

        if (len(nums)==0):
            return [-1,-1]
        if(target<nums[0] or target>nums[len(nums)-1]):
            return[-1,-1]
        first_index=binarysearchfirst(nums,target)
        if(first_index==-1):
            return [-1,-1]
        last_index=binarysearchlast(nums,target)
        return [first_index,last_index]


    def binarysearchfirst(nums,target):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=int(low+(high-low)/2)
            if(nums[mid]==target):
                if(mid==0 or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    high=mid-1
            elif(nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1

    def binarysearchlast(nums,target):
        low=first_index
        high=len(nums)-1
        while(low<=high):
            mid=int(low+(high-low)/2)
            if(nums[mid]==target):
                if(mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                    return mid
                else:
                    low=mid+1
            elif(nums[mid]>target):
                high=mid-1
            else:
                low=mid+1
        return -1
