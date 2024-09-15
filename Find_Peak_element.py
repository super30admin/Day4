# -*- coding: utf-8 -*-
"""
Time Complexity: O(log n)
Space complexity: O(n)
Did the problem run on Leetcode?: Yes

Problem: 
A peak element is an element that is greater than its neighbors.
Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that nums[-1] = nums[n] = -∞.
"""

class Solution:
    def findPeakElement(self, nums):
        l = 0
        h = len(nums) - 1
        
        while l <= h:
            mid = l + (h - l) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid+1]:
                l = mid + 1
            else:
                h = mid - 1
                
s = Solution()
print(s.findPeakElement([1,2,3,1]))
print(s.findPeakElement([5,4,1,3,9]))