'''
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

Note: Your solution should be in logarithmic complexity.
'''

'''
Approach:
- In this problem we use a modified binary search.
- We fist see the middle element, if the middle value is a peak (bigger than both its neighbours), return it.
- If the left neighbour is bigger than mid value, move to the left subarray else move right.

Time Complexity: O(logn)
Space Complexity: O(1)
'''
class Solution:
  def findPeakElement(self, nums):
    if nums == None or len(nums) == 0: 
      return -1

    low = 0
    high = len(nums) - 1
    while low <= high:
      mid = (low + high) // 2
      if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
        return mid
      elif nums[mid + 1] > nums[mid]: # always check right half before left half since mid always gets a lower value in case of even length due to integer division
        low = mid + 1
      else:
        high = mid - 1
    return -1


s = Solution()
nums1 = [1,2,3,4,5,1]
print('A peak index in {} is {}'.format(nums1, s.findPeakElement(nums1)))

nums2 = [1,2,1,3,5,6,4]
print('A peak index in {} is {}'.format(nums2, s.findPeakElement(nums2)))
