"""
## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.

TC = O(log n ), n is number of elements
SC = O(1)
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums==[]:
            return -1
        
        left_neighbor = 0
        right_neighbor = len(nums) - 1
        
        while (left_neighbor <= right_neighbor):
            peak = (left_neighbor + right_neighbor)//2
            
            if ((peak == 0 or nums[peak] > nums[peak-1])
               and (peak == len(nums) -1 or nums[peak] > nums[peak +1])
               ):
                
                return peak
            
            elif ((peak > 0) and nums[peak] < nums[peak-1]):
                right_neighbor  = peak - 1
                
            else:
                left_neighbor = peak +1 
                
                
        