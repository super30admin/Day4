"""

    Student : Shahreen Shahjahan Psyche

    This program passed all the test cases in Leetcode

    Time Complexity : O(log N)
    Memory Complexity : O(1)

"""

from typing import List

class Solution:
    
    def _binarySearchStart(self, nums, target):
        
        start = 0
        end = len(nums) -1
        
        while(start<=end):
            mid = (start + end)//2
            if(nums[mid] == target and (mid == 0 or nums[mid-1]<target)):
                return mid
            if nums[mid]<target:
                start = mid + 1
            else:
                end = mid -1 
                
        return -1
    
    def _binarySearchEnd(self, nums, target):
        
        start = 0
        end = len(nums) -1
        
        while(start<=end):
            mid = (start + end)//2
            if(nums[mid] == target and (mid == len(nums)-1 or nums[mid+1]>target)):
                return mid
            if nums[mid]<=target:
                start = mid + 1
            else:
                end = mid -1 
                
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if nums is None or len(nums) == 0:
            return [-1, -1]
        first = self._binarySearchStart(nums, target)
        last = self._binarySearchEnd(nums, target)
        
        return [first, last]
        
        
        