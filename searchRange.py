"""
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Time: OLogN
Space: O(1)

"""


class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        low = 0
        high = len(nums)-1
        
        while low <= high:
            mid = low + ((high - low) // 2); 
            #edge cases
            if nums is []: return [-1,-1]
            if target == 0: return [-1, -1]
            if target == nums[mid] and len(nums) == 1:
                return [mid, mid]
            
            if target == nums[mid] and target == nums[mid + 1]: 
                return [mid, mid + 1]
            if target == nums[mid] and target == nums[mid - 1]:
                return[ mid - 1, mid]


            elif target < nums[mid]:
                high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                return [mid, mid]
            #start and end of target must be next to each other. Sorted!
        return [-1, -1]

        #Out of bounds when [1,4] , 4