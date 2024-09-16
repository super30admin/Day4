"""
Time Complexity : O(2log(n)) ~ O(log(n))
Space Complexity : O(1)
"""

class Solution:
    def __init__(self):
        self.left_ = -1
        
    def binary_search_left(self, nums, target):
        l = 0
        h = len(nums) - 1 
        
        while l <= h:
            mid = l + (h-l)//2
            
            if nums[mid] == target:
                if mid == l or nums[mid] > nums[mid-1]:
                    self.left_ = mid
                    return mid 
                else:
                    h = mid - 1 
            
            elif nums[mid] > target:
                h = mid - 1
            
            else:
                l = mid + 1  
                
        return -1 
    
    def binary_search_right(self, nums, target):
        l = self.left_
        h = len(nums) - 1 
        
        while l <= h:
            mid = l + (h-l)//2
            
            if nums[mid] == target:
                if mid == h or nums[mid + 1] > nums[mid]:
                    return mid 
                else:
                    l = mid + 1 
            
            elif nums[mid] > target:
                h = mid - 1
            
            else:
                l = mid + 1  
                
        return -1 
            
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0:
            return [-1,-1]
        elif target < nums[0] or target > nums[-1]:
            return [-1,-1]
        left = self.binary_search_left(nums, target)
        if left == -1:
            return [-1,-1]
        right = self.binary_search_right(nums, target)
        return [left, right]