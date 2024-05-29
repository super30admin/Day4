'''
## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
'''

'''
Approach:
- For this problem we use a modification of binary search twice to find the start and end index individually.
- For start index, at every iteration of binary search, if the value at mid matches target but the adjacent left does not,
  that means we are at the start index. Else if the value on adjacent left is the same we move left.
- Similarly for end index we follow the same approach, except we check the adjacent right and move right if it's same.
- For both start and end, if mid value does not match target then we move left or right depending on smaller or greater condition 
  same at regular binary search.

Time Complexity: O(logn)
Space Complexity: O(1)
'''

class Solution:
  def searchRange(self, nums, target):
    if len(nums) == 0:
      return [-1, -1]
    low = 0
    high = len(nums) - 1
    start = self.getStartIndex(nums, target, low, high)
    end = self.getEndIndex(nums, target, low, high)
    return [start, end]

  def getStartIndex(self, nums, target, low, high):
    while low <= high:
      mid = (low + high) // 2
      if nums[mid] == target:
        if mid == low or nums[mid-1] != target:
          return mid
        high = mid - 1
      elif nums[mid] > target:
        high = mid - 1
      else:
        low = mid + 1
    return -1

  def getEndIndex(self, nums, target, low, high):
    while low <= high:
      mid = (low + high) // 2
      if nums[mid] == target:
        if mid == high or nums[mid+1] != target:
          return mid
        low = mid + 1
      elif nums[mid] > target:
        high = mid - 1
      else:
        low = mid + 1
    return -1

s = Solution()

nums1 = [5,7,7,8,8,10]
target1 = 7
print('Start and end of index of {} in {} are {}'.format(target1, nums1, s.searchRange(nums1, target1)))

nums2 = [5,7,7,8,8,10,12,12,12,12,12,12,12,14,14,14,15,15,15,15,15,15,16,16]
target2 = 12
print('Start and end of index of {} in {} are {}'.format(target2, nums2, s.searchRange(nums2, target2)))