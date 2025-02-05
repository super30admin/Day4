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


class Solution:
    def searchRange(self, nums, target):
        """
        Solution:
        1. First find whether element is present of not. If not present return [-1, -1]
        2. If present, consider the index found(mid) to be the range [mid, mid] and store the chunk where you found mid
        3. update low index by binary searching from low to mid and update high index by binary searching from mid to high

        --- Passed all Leetcode test cases.
        """

        # O(logn) Time Complexity | O(1) Space Complexity
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + int((high - low) / 2)
            if (nums[mid] == target):
                return [self.updateLow(nums, target, low, mid), self.updateHigh(nums, target, mid, high)]
            elif (nums[mid] > target):
                high = mid - 1
            else:
                low = mid + 1

        return [-1, -1]

    def updateHigh(self, nums, target, low, high):

        # O(logn) Time Complexity | O(1) Space Complexity
        higherId = low
        while (low <= high):
            mid = low + int((high - low) / 2)
            if (nums[mid] == target):
                higherId = mid
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                continue
        return higherId

    def updateLow(self, nums, target, low, high):

        # O(logn) Time Complexity | O(1) Space Complexity
        leastId = high
        while (low <= high):
            mid = low + int((high - low) / 2)
            if nums[mid] == target:
                leastId = mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                continue
        return leastId
        
        



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


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high = len(nums)-1
        while(low<=high):
            mid  = int((low+high)//2)
            if(nums[mid]<nums[high]):
                if(low==mid):
                    return nums[mid]
                high = mid
            elif(nums[mid]>nums[low]):
                if(high==mid):
                    return nums[mid]
                low = mid
            else:
                return min(nums[low],nums[high])
            
        


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

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low =0
        high = len(nums)-1
        while (low<high):
            mid  = (low +high)//2
            if ((mid==0 or nums[mid]>nums[mid-1] )and (mid==high or nums[mid]>nums[mid+1])):
                return mid
            elif (mid>0 and (nums[mid]<nums[mid-1])):
                high = mid-1
            elif(mid<high and (nums[mid]<nums[mid+1])):
                low = mid+1
            else:
                break
        return low





