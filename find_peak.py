#The idea is we will always find a peak element as long as we go towards the search space where the adjacent element is greater
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums)-1
        while (low<=high):
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):   #Check for outbounds for mid-1 and mid+1, check adjacent number is greater
                return mid
            elif mid!=0 and nums[mid]<nums[mid-1]:      #Second condition to account for out of bounds
                high = mid -1
            else:
                low = mid+1
        
#Time Complexity: O(Log N)
# Compiled in Leetcode            
        
    