"""
Time Complexity: O(logn)
Space Complexity: O(1)
Compiled on leetcode: Yes
Difficulties faced: No
"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                left = self.binarySearchLeft(nums, target, 0, mid)
                right = self.binarySearchRight(nums, target, mid, len(nums) - 1)
                return [left, right]
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return [-1, -1]
    
    def binarySearchLeft(self, nums, target, low, high):
        while low <= high:
            mid = (low + high) //2
            if mid == 0 and nums[mid] == target:
                return 0
            if nums[mid] == target and nums[mid - 1] < target:
                return mid
            elif nums[mid] == target:
                high = mid - 1
            else:
                low = mid + 1
        
    
    def binarySearchRight(self, nums, target, low, high):
         while low <= high:
            mid = (low + high) //2
            if mid == len(nums) - 1 and nums[mid] == target:
                return len(nums) - 1
            if nums[mid] == target and nums[mid + 1] > target:
                return mid
            elif nums[mid] == target:
                low = mid + 1
            else:
                high = mid - 1