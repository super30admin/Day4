"""
Time Complexity : O(LogN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        
        low = 0
        high = len(nums) - 1
        while(low <= high):
            
            mid = low + (high - low) // 2
            
            # the min element is the only one for which, 
            if(nums[mid] <= nums[mid - 1]):
                return nums[mid]
            
            if(nums[mid] < nums[high]):
                high = mid - 1
            else:
                low = mid + 1
                
        return -1