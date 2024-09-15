# S30 Big N Problem #9 {Medium}

#A peak element is an element whose value is greater than both of its neighbors.
#Provided an input array nums, such that nums[i] ≠ nums[i+1], find a peak element and return its index.
#The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
#You may imagine that nums[-1] = nums[n] = -∞.

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low,high=0,len(nums)-1
        
        while low<high:
            
            mid=low+(high-low)//2
            
            if mid!=0 and mid!=len(nums)-1 and nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:
                return mid
            elif nums[mid]<nums[mid+1]:
                low=mid+1
            else:
                high=mid-1
                
        return low
                
            
                
        
                
        