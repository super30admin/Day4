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
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == [] or len(nums) ==0:
            return -1,-1
        if target < nums[0] or target > nums[len(nums)-1]:
            return [-1,-1]
        first = self.Firstbinarysearch(nums,target)
        last = self.Lastbinarysearch(nums,target)
        return first,last
    def Firstbinarysearch(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        while low<=high:
            mid = low + (high-low)//2
            #first occourance
            if target == nums[mid]:
                if mid ==0 or nums[mid-1] < nums[mid]:
                        return mid
                elif nums[mid-1] == nums[mid]:
                        high = mid - 1
            elif target > nums[mid]:
                        low = mid + 1
            else:
                high = mid-1
        return -1
    def Lastbinarysearch(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        while low<=high:
            mid = low + (high-low)//2
            #last occourance
            if target == nums[mid]:
                if mid == len(nums)-1 or nums[mid+1] > nums[mid]:
                        return mid
                elif nums[mid+1] == nums[mid]:
                        low = mid + 1
            elif target > nums[mid]:
                        low = mid + 1
            else:
                high = mid-1
        return -1
<!--                    
        #Time Complexity: O(logn)
        #Space Complexity: O(n)
        #Approach: A sorted array is given -> do a binary search to find the first occourance and a second binary find the second occourance.  -->
        
            
        

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
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low +(high-low)//2
            if  nums[low] <=nums[high]:
                return nums[low]
            if (mid ==0 or nums[mid]<nums[mid-1]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1]):
                    return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid +1
            else:
                high = mid - 1
            
        return -1
<!-- # Time Complexity: O(logn)
#Space Complexity: O(n)
#Approach: first check if the array is sorted, if yes then directly return the first element. If not check whether low<mid and if yes, move your low pointers to the unsorted region and check again check untill you arrive at the happy case. We also check if the mid element is less than the neighbours.  -->

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

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        if nums == [] or len(nums)==0:
            return -1
        while low<=high:
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid>0 and nums[mid-1]>nums[mid]:
                high = mid-1
            else:
                low = mid+1
        return -1
    <!-- #Time Complexity: O(logn)
    #Space Complexity: O(n)
    #Approach - an unsorted array is given -> divide the array using binary search technique -> compare the element to its neighbours -> if greater return mid (happy case)
    # else find the side that has an increasing end move your pointers accordingly  -->
