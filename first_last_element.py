# Binary-Search-2

## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: we use binary search method to reduce the time complexity of traversing an entire array. Since array has duplicates, we have to find where the target is starting and ending. So after finding the mid element, we traverse left and right array separtely using binary search 


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = self.leftarray(nums, target, 0, len(nums)-1)
        right = self.rightarray(nums, target, 0, len(nums)-1)
        return [left, right]
    
    def leftarray(self, nums, target, low, high):
        while(low<=high):
            mid=low+(high-low)//2
            # check if the mid is target
            if target == nums[mid]:
                # check if the the element less than mid is different than mid, then return the mid
                if low == mid or nums[mid-1]<nums[mid]:
                    return mid
                # if the element less than mid is same, then traverse more left
                else:
                    high=mid-1
            elif nums[mid] > target:
                high=mid-1
            else:
                low=mid+1
        return -1
            
        
    
    def rightarray(self, nums, target, low, high):
        while(low<=high):
            mid=low+(high-low)//2
            # check if the mid is target
            if target == nums[mid]:
                # check if the the element greater than mid is different than mid, then return the mid
                if high == mid or nums[mid]<nums[mid+1]:
                    return mid
                 # if the element greater than mid is same, then traverse more right
                else:
                    low=mid+1
            elif nums[mid] > target:
                high=mid-1
            else:
                low=mid+1
        return -1
        
        