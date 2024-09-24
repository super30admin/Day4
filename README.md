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

// T.C = log(n)
// First, I checked if there are any numbers in the array; if not, it returns [-1, -1]. Then, I created functions to find the first and last occurrences of the target. In the first function, I checked if the middle element is at index 0 or if it equals the target. If so, I compare it to the previous element. If the previous element is smaller, it confirms we are at the first occurrence of the target. The same logic applies for finding the last occurrence.

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        if(nums is None or len(nums) == 0):
            return [-1,-1]

        n = len(nums) - 1

        first = self.binarySearchFirst(nums,0,n,target)
        if (first == -1):
            return [-1,-1]
        
        last = self.binarySearchLast(nums,first,n,target)
        return [first,last]

    def binarySearchFirst(self,nums,low,high,target):

        while(low<=high):
            mid = low + (high - low)//2
            if(nums[mid] == target):
                if(mid == 0 or nums[mid -1] < nums[mid] ):
                    return mid
                else:
                    high = mid -1
            elif(nums[mid] > target):
                high = mid - 1
            else:
                low = mid + 1

        return -1

    def binarySearchLast(self,nums,low,high,target):

        while(low<=high):
            mid = low + (high - low)//2
            if(nums[mid] == target):
                if(mid == len(nums) -1 or nums[mid + 1] > nums[mid] ):
                    return mid
                else:
                    low = mid + 1
            elif(nums[mid] > target):
                high = mid - 1
            else:
                low = mid + 1

        return -1

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

// T.C = log(n)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums == None or len(nums) == 0): 
            return -1
        low = 0
        high = len(nums) - 1

        while(low <= high):
            if(nums[low]<=nums[high]):
                return nums[low]
            
            mid = low + (high - low)//2

            if((mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1])):
                return nums[mid]
            elif(nums[mid] >= nums[low]):
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

// T.C = log(n)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1

        while(low<=high):
            mid = low + (high - low)//2
            if((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                return mid
            elif(mid > 0 and nums[mid - 1] > nums[mid] ):
                high = mid - 1
            else:
                low = mid + 1

        return -1
        
       


