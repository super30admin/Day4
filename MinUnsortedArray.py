# // Time Complexity : O(logn)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes

import sys


class Solution:
    def findMin(self, nums: list[int]) -> int:
        if not nums or len(nums) == 0:
            return -1
        
        low = 0
        high = len(nums)-1
        
        while (low<=high):
            if nums[low] <= nums[high]: return nums[low]  ## if we get sorted array the low will always be small than high
            
            mid = low + (high - low)//2  ## to prevent integer overflow
            
            ## check if the middle element is small i.e left and right should me larger than middle
            if ((mid == low or nums[mid-1] > nums[mid]) and (mid == high or nums[mid+1] > nums[mid])):
                return nums[mid]
            
            ## checking which part is sorted
            
            if nums[low] <= nums[mid]:
                low = mid+1
            else:
                high = mid -1
                
        return sys.maxint
            
            
        