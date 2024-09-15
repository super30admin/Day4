"""

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. 
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        # base case
        if nums == None or len(nums) == 0:
            return -1
        
        # setting up low and high to find mid for binary search
        low = 0
        high = len(nums) -1
        
        # logic
        while low <= high:
            
            mid = low + (high - low) // 2
            
            # for mid to be peak, it has to be only element or greatest element (greater than previous element)
            # as well as last element or greatest element (greater than next element)
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and 
                (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                return mid
            
            # changing high if peak lies in left half
            elif(mid != 0 and nums[mid] < nums[mid - 1]):
                high = mid - 1
                
            # changing low if peak lies in right half
            else:
                low = mid + 1
                
        return 1