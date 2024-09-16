"""

    Student : Shahreen Shahjahan Psyche

    This program passed all the test cases in Leetcode

    Time Complexity : O(log N)
    Memory Complexity : O(1)

"""

from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if nums is None or len(nums) == 0:
            return -1
        
        start = 0
        end = len(nums) - 1
        
        while(start <= end):
            if nums[start] <= nums[end]:
                return nums[start]
            mid = (start + end)//2
            
            if ((mid == 0 or nums[mid]<nums[mid - 1]) and (mid == len(nums)-1 or nums[mid+1]>nums[mid])):
                return nums[mid]
            
            if(nums[mid]<nums[end]):
                end = mid -1
            else:
                start = mid + 1 
        
        return -1 
        
        