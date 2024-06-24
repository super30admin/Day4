"""
## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

TC = O(log n ), n is number of elements
SC = O(1)
"""

class Solution:
    def findFirstPosition(self,nums, target, low, high):
        
        while (low<=high):
            
            mid = (low+high)//2
            if (nums[mid]==target):
                if (mid ==0 or nums[mid] != nums[mid-1] ):
                    return mid
                else:
                    high = mid-1
            
            elif (nums[mid] < target):
                low = mid+1
                
            else:
                high = mid - 1
                
        return -1
                
    def findLastPostion(self, nums, target, low, high):
        while (low<=high):
            
            mid = (low+high)//2
            if (nums[mid]==target):
                if ((mid == len(nums) -1) or (nums[mid] != nums[mid+1])):
                    return mid
                else:
                    low = mid+1
            
            elif (nums[mid] < target):
                low = mid+1
                
            else:
                high = mid - 1
                
        return -1
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        res = [-1, -1]            
        if nums==[]:
            return res
     
        low = 0
        high = len(nums) -1
       
        
        #check if the array is uniform
        if (nums[low] == nums[high] and nums[low] == target):
            return [low, high]
        
        
        #find the first position
        first = self.findFirstPosition(nums, target, 0, len(nums)-1)
                    
        if first == -1:
            return [-1, -1]
                    
        last = self.findLastPostion(nums, target, first, len(nums)-1)
                    
        return [first, last]