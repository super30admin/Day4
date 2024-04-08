# Binary-Search-2

## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Approach
# Run binary search on left and right side to get low and high index.
# For low index, check if mid == target and mid -1 !=mid, then return mid. Else, set high to mid-1 and repeat the process. if nums[mid] < target: low = mid + 1
# for high index, check if mid ==target: if mid+1 != mid, return mid. Else, set low = mid+1. if nums[mid] > target: low = high - 1   


#Time Complexity: O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or nums is None:
            return [-1,-1]
        
        if len(nums) == 1 and nums[0] != target:
            return [-1,-1]

        if target < nums[0] or target > nums[len(nums)-1]:
            return [-1,-1]
            
        left = self.binarySearchLeft(nums, target)
        if left == -1:
            return [-1,-1]
        
        right = self.binarySearchRight(nums, target)
        return [left,right]

    def binarySearchLeft(self, nums: List[int], target: int):
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] != target:
                    return mid
                else:
                    high = mid -1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def binarySearchRight(self, nums: List[int], target: int):
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] != target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1