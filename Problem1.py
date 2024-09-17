# ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

# Your algorithm's runtime complexity must be in the order of O(log n).

# If the target is not found in the array, return [-1, -1].

# Example 1:

# Input: nums = [5,7,7,8,8,10], target = 8
# Output: [3,4]
# Example 2:

# Input: nums = [5,7,7,8,8,10], target = 6
# Output: [-1,-1]

class Solution(object):
    def searchRange(self, nums, target):
        left = self.bsearch(True,target,nums)
        right = self.bsearch(False,target,nums)
        return [left, right]
    # leftbias[true/false] , if false res is rightbias
    # leftbias means that we are looking for the left most index of the target
    # rightbias means we are looking for the rightmost index of the target
    def bsearch(self,leftbias,target,nums):
        left,right = 0, len(nums)-1
        i = -1
        while left<=right:
            mid = (left+right)//2
            if target > nums[mid]:
                left = mid + 1
            elif target < nums[mid]:
                right = mid - 1
            else:
                i = mid
                if leftbias:
                    right = mid - 1
                else:
                    left = mid + 1
        return i
    
# Time Complexity -> log(n)
# Space Complexity -> o(1)
