from typing import List

# Time Complexity : 0(logn)
# Space Complexity : 0(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or target > nums[-1] or target < nums[0]:
            return [-1,-1]
        first = self.binarysearchFirst(nums, target)
        if first == -1:
            return [-1,-1]
        second = self.binarysearchSecond(nums,target)
        return [first,second]

    def binarysearchFirst(self, nums,target):
        low = 0 
        high = len(nums) -1

        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid -1]:
                    return mid
                high = mid -1
            elif nums[mid] < target:
                low = mid +1
            else:
                high = mid -1
        return -1

    def binarysearchSecond(self, nums, target):
        low = 0 
        high = len(nums) -1