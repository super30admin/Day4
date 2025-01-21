"""

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.


Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# The approach uses binary search to efficiently find the minimum element in a rotated sorted array.  
# If the last element is greater than the first, the array is already sorted, and the first element is the minimum.  
# Otherwise, search by checking midpoints and adjusting boundaries based on comparisons to find the pivot point where rotation occurs.  


class Solution:
    def findMin(self, nums: List[int]) -> int:

        left, right = 0, len(nums) - 1

        if nums[right] > nums[0]:
            return nums[0]

        while left <= right:
            mid = (left+right) // 2

            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            if nums[mid-1] > nums[mid]:
                return nums[mid]

            if nums[mid] > nums[0]:
                left = mid + 1
            else:
                right = mid - 1
