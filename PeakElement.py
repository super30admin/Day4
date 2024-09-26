# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The base cases will check for peak in the first and last element of the array
# While checking the mid in binary search, we check if element before mid is greater.
# If yes, then we change right pointer and check for peak to the left of mid
# Same for the right side

from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
 
        # REMEMBER: We have to return any one peak.
        if len(nums)==1:
            return 0
        elif nums[0]>nums[1]:
            return 0
        elif nums[len(nums)-1]>nums[len(nums)-2]:
            return len(nums)-1
        
        l=0
        r=len(nums)-1
        
        while l<=r:
            mid=(l+r)//2
            
            if nums[mid-1]<nums[mid]>nums[mid+1]:
                return mid
            elif nums[mid]<nums[mid-1]:
                r=mid-1
            elif nums[mid]<nums[mid+1]:
                l=mid+1
        return -1
                
        