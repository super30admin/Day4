# Time Complexity : O(log(n^2)) because we are doing BS two time on same array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


from typing import List

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or not nums: return [-1,-1]
        first = self.binarySearchFirst(nums, target)
        if first == -1: return [-1,-1]
        last = self.binarySearchLast(nums, target, first)
        return [first, last]

    def binarySearchFirst(self, nums, target):
        low, high = 0, len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                # we'll check if mid the first index of target ??
                if mid == 0 or nums[mid] != nums[mid - 1]: return mid
                else: high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else: low = mid + 1
        return -1 
    
    def binarySearchLast(self, nums, target, first):
        low, high = first, len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == high or nums[mid] != nums[mid + 1]: return mid
                else: low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1