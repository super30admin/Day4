'''
## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0

'''

'''
Approach:
In this problem we use a modified binary search
We use a special property of a rotated sorted array. The property is that when a rotated sorted array is split in 2 halves, atleast one half is sorted.
We fist see the middle element, if the middle element is smaller than both its adjacent neighbours, it means it's the mininum value in the array.
If not, we look for the sorted subarray on both the sides (by simply comparing the fisrt and last value) and return the leftmost value in the sorted subarray.

Time Complexity: O(logn)
Space Complexity: O(1)
'''
class Solution:
  def findMin(self, nums):
    low = 0
    high = len(nums) - 1
    while low <= high:
      if nums[low] <= nums[high]: # if the subarray is sorted, return the element at the first index i.e. nums[low]
        return nums[low]
      mid = (low + high) // 2
      if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
        return nums[mid]
      if nums[low] <= nums[mid]: # if left sub array is sorted, move right
        low = mid + 1
      else: # else move left
        high = mid - 1
    return -1


s = Solution()
nums1 = [3,4,5,1,2]
print('The minimum value in {} is {}'.format(nums1, s.findMin(nums1)))

nums2 = [4,5,6,7,0,1,2]
print('The minimum value in {} is {}'.format(nums2, s.findMin(nums2)))
