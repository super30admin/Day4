"""
Time Complexity : O(log(n))
Space Complexity : O(1)
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1 
       
        l = 0 
        h = len(nums) - 1 
        
        while l <= h: 
            if nums[l] <= nums[h]:
                return nums[l]
    
            mid = l + (h-l)//2
            
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid+1] > nums[mid]):
                return nums[mid]
            
            elif nums[mid] >= nums[l]:
                l = mid + 1 
            
            else:
                h = mid - 1 
                
        return -1
        







