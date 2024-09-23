# Binary-Search-2
Explain your approach in **three sentences only** at top of your code


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

# Explanation
1. Apply binarysearch on the left side of an array to determine the first index.
2. Apply binarysearch on the right side of an array to determine the last index.
3. Time Complexity is O(log n)

## Code
class Solution(object):

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if(len(nums)==0):
            return [-1,-1]
        def bsFirst(low,high,target,nums):

            while(low<=high):
                mid = low + (high-low)//2

                if(nums[mid] == target):
                    if(mid==0 or nums[mid] > nums[mid-1]):
                        return mid
                    else:
                        high = mid - 1
                else:
                    if(target > nums[mid]):
                        low = mid + 1
                    else:
                        high = mid -1
            return -1
    
        def bsSecond(low,high,target,nums):
            while(low <= high):
                mid = low + (high - low) // 2

                if(nums[mid] == target):
                    if(mid==high or nums[mid] < nums[mid+1]):
                        return mid
                    else:
                        low = mid + 1
                else:
                    if(target > nums[mid]):
                        low = mid + 1
                    else:
                        high = mid - 1
            return -1
        first = bsFirst(0,len(nums)-1,target,nums)
        if(first == -1):
            return [-1,-1]
        second = bsSecond(first,len(nums)-1,target,nums)
        return [first,second]




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

# Explanation
1. Check if the first value is less than the last value; if so, nums[low] is the lowest number.
2. Find the middle element and check its adjacent elements. If the middle element is lower than its adjacent elements, then the middle element is the lowest.
3. Otherwise, go to the unsorted part to find the lowest element, because there is a rotation point, and the rotation point will always be the lowest element.

## Time Complexity = O(log n)
## Code
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        low = 0
        high = len(nums)-1
        while low <= high:
            print(low)
            print(high)
            if(nums[low] <= nums[high]):
                return nums[low]
            mid = low + (high-low) // 2
            print(mid)
            if((mid==0 or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid+1])):
                return nums[mid]
            if(nums[mid] >= nums[low]):
                low = mid + 1
            else:
                high = mid - 1
        return -1
            

        


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
Note:

Your solution should be in logarithmic complexity.

# Explanation
1. Check if the middle number is the peak element. If it is, simply return the middle element.
2. Otherwise, move to the side with the higher element. If nums[mid] < nums[high], search the higher part, and vice versa.
3. The time complexity is O(log n).

# Code
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high-low) // 2

            if((mid == 0 or nums[mid] > nums[mid-1]) and (mid == high or nums[mid] > nums[mid+1])):
                return mid
            elif(mid == high or nums[mid] < nums[mid+1]):
                low = mid + 1
            else:
                high = mid -1
        return low


