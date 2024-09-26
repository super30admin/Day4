# Time complexity - O(logn)
# Space complexity - O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        searching_Lindex = self.L_index(nums, target, 0, len(nums) - 1)
        if searching_Lindex == -1:
            return [-1, -1]
        
        searching_Rindex = self.R_index(nums, target, 0, len(nums) - 1)
        return [searching_Lindex, searching_Rindex]
    
    def L_index(self, nums: list[int], target: int, low: int, high: int):
        result_left = -1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                result_left = mid
            
            if nums[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
            
        return result_left
            
    
    def R_index(self, nums: list[int], target: int, low: int, high: int):
        result_right = -1
        
        while low <= high:
            mid = low + (high - low) // 2
            
            if nums[mid] == target:
                result_right = mid
            
            if nums[mid] <= target:
                low = mid + 1
            else:
                high = mid - 1
            
        return result_right   
        
