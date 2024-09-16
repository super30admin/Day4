# -*- coding: utf-8 -*-
"""
Created on Sat Feb  5 18:21:35 2022

@author: BJay
"""

#Time Complexity : O(lon(n))
#Space Complexity : O(1)
#Passes the all test cases on leetcode
#I tried with binarysearch by my own first but I couldn't get through all the test cases

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start, end = 0,len(nums)-1
        while start <= end:
            mid = start + (end - start)//2
            midGThanLeft = (mid == 0) or (nums[mid] > nums[mid-1])
            midGThanRight = (mid == len(nums)-1) or (nums[mid] > nums[mid+1])
            # if mid is peak
            if midGThanRight and midGThanLeft:
                return mid
            
            # if midGThanLeft -> go right
            if midGThanLeft:
                start= mid + 1
                
            # else go => left
            else:
                end = mid - 1
        return -1
            
        # if len(nums) == 1:
        #     return 0
        # if len(nums)==2:
        #     if nums[0]>nums[1]:
        #         return 0
        #     else:
        #         return 1
        # if len(nums)>2:
        #     p1 = 1
        #     p2 = 1
        #     while True and p2+1 < len(nums):
        #         if nums[p1] > nums[p1+1] and nums[p1] > nums[p1-1]:
        #             return p1
        #         elif nums[p2] > nums[p2+1] and nums[p2] > nums[p2-1]:
        #             return p2
        #         p1 = p1+1
        #         p2 = p2+2
        #     if nums[0]<nums[-1]:
        #         return len(nums)-1
        #     else:
        #         return 0
#         peakEle = 2**31 - 1
#         s = 0
#         e = len(nums)-1
        
#         while s <= e:
#             mid = s + (e-s)//2
#             if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
#                 return nums[mid]
#             elif nums[mid] < nums[e] and nums[mid] > nums[s]:
#                 s = mid+1
#             else:
#                 e = mid-1
#         return nums[-1]
        