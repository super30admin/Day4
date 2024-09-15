# -*- coding: utf-8 -*-
"""
Time Complexity: O(log n)
Space complexity: O(n)
Did the problem run on Leetcode?: Yes

Problem:
uppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element. You may assume no duplicate exists in the array.
"""

class Solution:
    def findMin(self, nums):
        if len(nums) == 0:
            return -1
        
        l = 0
        h = len(nums) - 1
        while (l < h):
            mid = l + (h - l) // 2
            if (nums[mid] > nums[h]):
                l = mid + 1
            else:
                h = mid
        
        return nums[l]
    
s = Solution()
print(s.findMin([5,6,7,8,0,1,2]))
print(s.findMin([3,1]))
print(s.findMin([20,30,45,3,12,19]))