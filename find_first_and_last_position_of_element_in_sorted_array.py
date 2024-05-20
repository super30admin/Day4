"""
Binary-Search-2
Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] 

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]

Time Complexity : O(logn)
Space Complexity :  O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
To find the first and last occur we're going to perform binary search for each of it. But while doing binary search for finding first occurence when we come across the 
mid we need to check if mid > low and mid-1 is also the target if yes, then we have to perform the binary search on left side else we can return the mid since it's the first_occurence. Similarly
for the last occur we check if mid < high and mid + 1 is also the target if yes, then we have to perform the binary search on right side else we can return the mid since it's the last occurence. For default if we don't find
mid we'll return -1. 
"""

class Solution:
    
    def find_first_occur(self, nums, target):
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid > low and nums[mid-1] == target:
                    high = mid - 1
                else:
                    return mid
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1
    
    def find_last_occur(self, nums, target):
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid < high and nums[mid+1] == target:
                    low = mid + 1
                else:
                    return mid
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0:
            return [-1, -1]


        first_occur = self.find_first_occur(nums, target)
        if first_occur == -1:
            return [-1, -1]
        second_occur = self.find_last_occur(nums, target)

        return [first_occur, second_occur]
    

