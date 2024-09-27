# -*- coding: utf-8 -*-
"""
Created on Sun Sep 20 20:47:59 2020

@author: Tripti Santani

Time Complexity: O(log N)
Space Complexity: O(1)

Approach:
    Step1: Initialize start and end
    Step2: If the value at start index is less than the value at end index, that means the pivot is at
           beginning and is the minimum element, therefore we return the element at start index
    Step3: Start a while loop with terminating condition start<end
    Step4: Find the middle index
    Step5: If nums[mid] is less than nums[end], then array is sorted on the right of the mid.
           Therefore, pivot lies on the left and end is mid. We are not doing end = mid-1 since 
           minimum element can be at mid index as well
    Step6: If minimum does not lie on the right, that means it lies on the left. Therefore, 
           updating start with mid+1
    Step7: Once we exit from loop, return nums[start] as it will be the minimum element
    
    
Code running successfully on leetcode
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        start = 0
        end = len(nums) - 1
        
        # For handling the input nums=[1,2,3,4,5,6,7]
        if nums[start] <= nums[end]:
            return nums[start]
        
        while(start<end):
            mid = int(start+(end-start)/2)
            
            # if nums[mid] is less than nums[end], then array is sorted on the right of the mid.
            # Therefore, pivot lies on the left
            # We are not doing end = mid-1 since minimum element can be at mid index as well
            if nums[mid]<nums[end]:
                end = mid
            
            else:
                start = mid + 1
        
        return nums[start]