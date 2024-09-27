# // Time Complexity : logn+logn ==logn
# // Space Complexity :
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

# Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
# Your algorithm's runtime complexity must be in the order of O(log n).
# If the target is not found in the array, return [-1, -1].
# Example 1:
# Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
# Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        f=self.findFirst(nums,target,0,len(nums)-1)
        l=self.findLast(nums,target,0,len(nums)-1)
        return [f,l]
    def findFirst(self, nums,target, start, end):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int(left + (right-left)/2)
            if nums[mid] == target:
                if mid == 0 or nums[mid-1]<target:
                    return mid
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return -1

    def findLast(self, nums, target, start, end):
        left, right = 0, len(nums)-1
        while left <= right:
            mid = int(left + (right-left)/2)
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1]>target:
                    return mid
                left = mid + 1
            elif nums[mid] <target:
                left = mid + 1
            else:
                right = mid -1
        return -1