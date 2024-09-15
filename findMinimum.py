# Time complexity - O(logn)
# Space complexity - O(1)

# Ran on Leetcode - Yes


class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            
            mid = left + (right-left)//2
            
            if nums[mid] >= nums[left] and nums[mid] <= nums[right]:
                
                return nums[left]
        
                
            elif nums[mid] <= nums[right]:
                right = mid 
                
            elif nums[mid] >= nums[left]:
                left = mid + 1
                
            
            