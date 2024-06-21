# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].


#Time Complexity: O(logn)
#Space Complexity:O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Implemented two binary search functions to find the first and last occurrences of target by comparing target with low and high.
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def FirstOccurence(nums, target):
            low, high = 0, len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] >= target:
                    high = mid-1
                else:
                    low = mid + 1
            return low

        def LastOccurence(nums, target):
            low, high = 0, len(nums) - 1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] <= target:
                    low = mid+1
                else:
                    high = mid-1
            return high
        
        start = FirstOccurence(nums, target)
        end = LastOccurence(nums, target)
        
        if start <= end and nums[start] == target and nums[end] == target:
            return [start, end]
        else:
            return [-1, -1]
        
solution = Solution()
nums = [5,7,7,8,8,10]
target=7
Occurences = solution.searchRange(nums,target)
print("The occurences of target in array :", Occurences)

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

#Time Complexity: O(logn)
#Space Complexity:O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Rotated array - atleast one part of array will be sorted, so that i have compared with middle element and right element to find minimum element among the array.
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left,right = 0,len(nums)-1
        while left<right:
            mid = left+(right-left)//2
            if nums[mid]>nums[right]:
                left = mid+1
            else:
                right = mid
        return nums[left]

solution= Solution()
nums = [3,4,1,5,2]
Min_element = solution.findMin(nums)
print("The Minimum element present in the rotated sorted array is :", Min_element)

Example 1:
Input: [3,4,5,1,2]
Output: 1

Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0

## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

#Time Complexity: O(logn)
#Space Complexity:O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#finding the peek element by comparing mid element with its neighbors by using binary search.

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low,high = 0,len(nums)-1
        while low<high:
            mid = low+(high-low)//2
            if nums[mid] > nums[mid+1]:
                high = mid
            else:
                low = mid+1
        return high

solution = Solution()   
nums = [1,6,5,1]
peek_index = solution.findPeakElement(nums)
print("The Peek element corresponding to peek index:",peek_index)

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 

             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.


