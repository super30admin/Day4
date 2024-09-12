# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, r = self.binLeftmost(nums, target), self.binRightmost(nums, target)
        
        if l <= r:
            return [l, r]
        return [-1, -1]
    
    def binLeftmost(self, nums, target):
        l = 0
        h = len(nums) - 1
        
        while l <= h:
            m = l + (h-l)//2
            
            if nums[m] < target:
                l = m + 1
            else:
                h = m - 1
                
        return l
        
    def binRightmost(self, nums, target):
        l = 0
        h = len(nums) - 1
        
        while l <= h:
            m = l + (h-l)//2
            
            if nums[m] <= target:
                l = m + 1
            else:
                h = m - 1
                
        return h