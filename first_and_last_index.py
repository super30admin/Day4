# Time Complexity: O(logn)
# Space Complexity: O(1)
# Ran on Leetcode: Yes
# Difficulties: Understanding the conditions to return element

class Solution:
    def binarySearchFirst(self, nums, target):
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = l + (h - l) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid
                elif nums[mid - 1] == nums[mid]:
                    h = mid - 1
            elif nums[mid ] < target:
                l = mid + 1
            else:
                h = mid - 1  
        return -1
    
    def binarySearchLast(self, nums, target, l):
        h = len(nums) - 1
        while l <= h:
            mid = l + (h - l) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                    return mid
                elif nums[mid + 1] == nums[mid]:
                    l = mid + 1
            elif nums[mid ] < target:
                l = mid + 1
            else:
                h = mid - 1  
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not len(nums):
            return [-1, -1]
        if target < nums[0] or target > nums[len(nums)-1]:
            return [-1, -1]
        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return[-1, -1]
        last = self.binarySearchLast(nums, target, first)
        return [first, last]