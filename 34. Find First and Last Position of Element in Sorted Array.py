# -*- coding: utf-8 -*-
"""
Created on Sat Feb  5 19:02:45 2022

@author: BJay
"""
#Time Complexity : O(log(n))
#Space Complexity : O(1)
#Runs fine on leetcode
#I tried my way but couldn't pass all the test cases
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        result =[]
        result.append(self.findFirst(nums,target))
        result.append(self.findLast(nums,target))
        return result
    
    def findFirst(self,nums:List[int],target:int) -> int:
        low = 0
        high = len(nums)-1
        index = -1
        while low <= high:
            #(low+high)>>1
            mid = low + (high-low)//2
            if target == nums[mid]:
                if mid==0 or nums[mid-1]!=target:
                    return mid
                else:
                    high = mid-1
            elif nums[mid] > target:
                high = mid-1
            else:
                low = mid+1 
        return -1
    def findLast(self,nums:List[int],target:int) -> int:
        low = 0
        high = len(nums)-1
        index = -1
        while low <= high:
            #(low+high)>>1
            mid = low + (high-low)//2
            if target == nums[mid]:
                if mid == len(nums)-1 or nums[mid+1] != target:
                    return mid
                else:
                    low = mid+1
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
            
        return -1
                
            
        
        
        
        
        
        
        
        
        
        
        
        
        
#         low = 0
#         high = len(nums)-1
#         flag = 1
#         firstInd = -1
#         lastInd = -1
#         while low<=high:
#             mid = low + (high-low)//2
            
#             if nums[mid] == target:
#                 if flag or firstInd>lastInd:
#                     firstInd = lastInd
#                     flag = 0
#                 lastInd = mid
#             if nums[low] == target:
#                 if flag or firstInd>lastInd:
#                     firstInd = low
#                     flag = 0
#                 lastInd = low
                
#             if target >= nums[mid]:
#                 low = mid+1
#                 # if nums[mid-1] == target:
#                 #     low = mid-1
#                 # else:
#                 #     low = mid+1
#             else:
#                 high = mid-1
#                 # if nums[mid+1] == target:
#                 #     high = mid+1
#                 # else:
#                 #     high = mid-1
#         if firstInd > lastInd:
#             temp = firstInd
#             firstInd = lastInd
#             lastInd = temp
#         return [firstInd,lastInd]
            
        