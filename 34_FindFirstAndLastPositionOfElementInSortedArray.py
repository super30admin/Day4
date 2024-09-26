"""
Leetcode - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/ (submitted)
TC - O(logN), SC- O(1)
Challenge - coming up with the logic in log(N)
Lecture - https://www.youtube.com/watch?v=LEq2VfGnNzI&ab_channel=%7BS30%7D

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
"""

'''
Idea - Two pass binary search. Find first element. From that index, do another binary search pass for last element.

Another approach will be a linear search in O(N) brute force
'''


class Solution:

    def searchRange(self, nums, target):
        firstIndex = self.binarySearch('first', nums, target, 0, len(nums) - 1)
        lastIndex = self.binarySearch('last', nums, target, firstIndex, len(nums) - 1)
        return [firstIndex, lastIndex]

    # TC - O(2*logN) = O(logN)
    def binarySearch(self, direction, arr, target, low, high):
        if low == -1:
            return -1
        resultIndex = -1
        while low <= high:
            mid = low + (high - low) // 2  # 2, 4
            if direction == 'first':
                if target <= arr[mid]:  # 8<=7, 8<=8
                    if arr[mid] == target:
                        resultIndex = mid  # 4
                    high = mid - 1  # 5
                else:
                    low = mid + 1  # 3
            else:
                if target >= arr[mid]:  # | 8 >= 8, 8 >= 8
                    if arr[mid] == target:
                        resultIndex = mid  # | 4
                    low = mid + 1  # | 4
                else:
                    high = mid - 1

        return resultIndex


nums = [5, 7, 7, 8, 8, 10]
target = 7
findRange = Solution().searchRange(nums, target)
print(findRange)
