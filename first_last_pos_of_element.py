#!/usr/bin/env python
# coding: utf-8

# In[ ]:


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if (len(nums) == 0 or nums == None): return [-1, -1]
        if target < nums[0]:
            return [-1, -1]
        if (target > nums[len(nums)-1]): return [-1, -1]
        
        firstOccur = self.BinarySearchLeft(nums, target)
        if (firstOccur == -1): return [-1, -1]
        lastOccurence = self.BinarySearchRight(nums, target, firstOccur)
        return [firstOccur, lastOccurence]
        
    def BinarySearchLeft(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low ) // 2
            if nums[mid] == target:
                if (mid == 0 or nums[mid-1] < nums[mid]):
                    return mid
                high = mid -1
            elif (target < nums[mid]):
                high = mid -1
            else:
                low = mid +1 
        return -1
        
    def BinarySearchRight(self, nums: List[int], target: int, firstOccurence):
        low = firstOccurence
        high = len(nums) -1
        while (low <= high):
            mid = low + (high - low ) // 2
            if nums[mid] == target:
                if (mid == len(nums) - 1 or nums[mid+1] > nums[mid]):
                    return mid
                low = mid + 1
            elif (target < nums[mid]):
                high = mid -1
            else:
                low = mid +1 
        return -1

