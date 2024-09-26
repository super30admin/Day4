"""
Leetcode- https://leetcode.com/problems/find-peak-element/submissions/ (submitted)
TC - O(logN), SC- O(1)
Challenge - thinking of binary search as a solution for this problem
Lecture - https://www.youtube.com/watch?v=LEq2VfGnNzI&ab_channel=%7BS30%7D

A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

Constraints:
1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i
"""

'''
Idea - binary search
Go in only the direction where the value is raising, you are surely going to find a peak in that direction. 
If the values on that side keeps going up, your last element would be the peak.
'''


class Solution:
    #  if peak at index 'x': check if the neighbors exists and is peak
    def isPeak(self, arr, length, x):
        if x - 1 < 0 and x + 1 >= length:
            return True
        elif x - 1 < 0 and arr[x] > arr[x + 1]:
            return True
        elif x + 1 >= length and arr[x] > arr[x - 1]:
            return True
        elif arr[x] > arr[x - 1] and arr[x] > arr[x + 1]:
            return True
        return False

    # TC - O(logN) since are using binary search
    def findPeakElement(self, nums):
        length = len(nums)
        low, high = 0, length - 1
        while low <= high:
            mid = low + (high - low) // 2
            if self.isPeak(nums, length, mid):
                return mid
            # pick higher side
            elif mid + 1 < length and nums[mid + 1] > nums[mid]:
                low = mid + 1
            elif mid - 1 >= 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1


arr = [1, 2, 1, 3, 5, 6, 4]
peak = Solution().findPeakElement(arr)
print('Peak index is: ', peak)
