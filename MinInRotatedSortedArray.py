# Leet Code Problem 153
# Find Minimum in Rotated Sorted Array
# Language Used : Python
# Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
# Runtime: 20 ms, faster than 96.84% of Python online submissions for Find Minimum in Rotated Sorted Array.
# Memory Usage: 13.8 MB, less than 8.03% of Python online submissions for Find Minimum in Rotated Sorted Array.


import math
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        first = 0
        last = len(nums)-1
        while last>first:
            middle=(first+last)//2
            if nums[middle]<nums[last]:
                last=middle
            else:
                first=middle+1
        return(nums[first])
            