"""
Time Complexity : O(log(n))
Space Complexity : O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1 
        
        l = 0
        h = len(nums) - 1 
        
        while l <= h:
            mid = l + (h-l)//2
            
            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid+1] < nums[mid])  :
                return mid
            elif mid != len(nums) - 1 and nums[mid] < nums[mid+1]:
                l = mid + 1
            elif mid != 0 and nums[mid] < nums[mid-1]:
                h = mid - 1 
        
        return -1
            