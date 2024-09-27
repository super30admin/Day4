# // Time Complexity : O(log(n) + log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = self.leftmost(nums, target)
        right = self.rightmost(nums, target)
        
        return [left, right]
    
    
    def leftmost(self, nums, target):
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low + (high-low)//2
            
            if (nums[mid] == target):
                if (mid == low or nums[mid-1] != target):
                    return mid
                high = mid-1
            elif nums[mid]> target:
                high = mid -1
            else:
                low = mid+1
        return -1
            
    def rightmost(self, nums, target):
        low = 0
        high = len(nums)-1
        
        while low<=high:
            mid = low + (high-low)//2
            
            if (nums[mid] == target):
                if (mid == high or nums[mid+1] != target):
                    return mid
                low = mid+1
            elif nums[mid]> target:
                high = mid -1
            else:
                low = mid+1
        return -1