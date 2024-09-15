# Space Complexity: O(1)
# Time Coplexity: O(logn)
# Did code run succesfully ion Leetcode: Yes
from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) -1
        # If there is only one element that 
        # element itself is min
        if len(nums) == 1:
            return nums[0]
        if nums[high] > nums[0]:
            return nums[0]
        # Binary search 
        while low <= high:
            mid = low + (high - low)//2
            # if next element to mid 
            # then that is lowest
            if nums[mid+1] < nums[mid]:
                return nums[mid+1]
             # if next element to mid 
            # then that is lowest
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            if nums[mid] > nums[0]:
                low = mid+1
            else:
                high = mid - 1