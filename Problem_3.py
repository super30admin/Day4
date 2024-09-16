"""

    Student : Shahreen Shahjahan Psyche

    This program passed all the test cases in Leetcode

    Time Complexity : O(log N)
    Memory Complexity : O(1)

"""

from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        # edge case
        if nums is None or len(nums) == 0 :
                return -1
            
        start = 0
        end = len(nums)-1
        
        while(start<=end):
            mid = (start + end) // 2
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == (len(nums)-1) or nums[mid + 1] < nums[mid]):
                return mid
            elif mid < len(nums) and nums[mid + 1] > nums[mid] :
                start = mid + 1
            else:
                end = mid - 1
                
        return -1 
            
            
        