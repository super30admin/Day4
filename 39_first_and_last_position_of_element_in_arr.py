# Time complexity - O(log n)
# Space complexity - O(1)
# Approach - Implement 2 BSs, first one - keep going till mid element is first occurence of target
# second one - same for last occurence of element

from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1, -1]
        
        if len(nums) == 1:
            if nums[0] == target:
                return [0,0]
            else:
                return [-1,-1]
        
        first = self.bsfirst(target, nums)
        if first == -1:
            return [-1,-1]
        last = self.bslast(target, nums)
        return [first, last]
    
    def bsfirst(self, target: int, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + ((high - low) // 2)

            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
    def bslast(self, target: int, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + ((high - low) // 2)

            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] != nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1