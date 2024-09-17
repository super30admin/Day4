# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes

class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        if not nums or len(nums)==0: return -1
        
        low =0
        high = len(nums)-1
        
        while low<=high:
            
            mid = low+(high-low)//2
            
            if ((mid == low or nums[mid-1] < nums[mid]) and (mid == high or nums[mid+1] < nums[mid])):
                return mid
            elif mid == high or nums[mid+1]>nums[mid]:
                low = mid+1
            else:
                high = mid-1
                
        return 3456789