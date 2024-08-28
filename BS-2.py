# Binary-Search-2
## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1,-1]
        first = self.binarySearchFirst(target, nums)
        if first == -1:
            return [-1,-1]
        second = self.binarySearchSecond(target, nums)
        return [first, second]

    def binarySearchFirst(self,target: int, nums: List[int])-> int:
        low = 0
        high = len(nums)-1
        while low<= high:
            mid = low + (high- low) #prevent integer overflow
            if nums[mid] == target:
                if (mid == 0) or (nums[mid-1]!=nums[mid]):
                    return mid
                else:
                    high = mid-1
            elif target > nums[mid]:
                low = mid+1
            else:
                high= mid-1
        return -1

    def binarySearchSecond(self,target: int, nums: List[int])-> int:
        low = 0
        high = len(nums)-1
        while low<= high:
            mid = low + (high- low) #prevent integer overflow
            if nums[mid] == target:
                if (mid ==len(nums)-1)or (nums[mid+1]!= nums[mid]):
                    return mid
                else:
                    low = mid+1
            elif target > nums[mid]:
                low = mid+1
            else:
                high = mid -1
        return -1

## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1
        while low<=high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high-low)//2
            if (nums[mid] < nums[mid-1] or mid ==low) and (nums[mid] < nums[mid+1] or mid == high):
                return nums[mid]
            if nums[low]<=nums[mid]:
                low = mid+1
            else:
                high = mid-1
        return 54567 #never get executed
#TC = O(log n)    

## Problem 3: (https://leetcode.com/problems/find-peak-element/)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        if len(nums) == 1:
            return 0
        low = 0
        high = len(nums)-1
        while low <= high:
            mid = low +(high-low)//2 #prevent integer overflow
            if (mid ==0 or nums[mid] > nums[mid-1]) and (mid ==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid ==0 or nums[mid]>nums[mid-1]:
                low=mid+1                               
            else:
                high=mid-1
                
        return 456789 #return garbage value