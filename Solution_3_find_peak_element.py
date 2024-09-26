// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. Goal is move towards increasing element compared to mid because both the 
   sides end at -infinity, so if its increasing, the number have to decrease 
   to reach -inf meaning peaking is in that direction.
2. Also check for each mid value, if its peak by comparing to 
   elements before and after it.
3. Edge cases will be when mid at begining oe ending og the list
   as it can cause out of bound error. 
4. Handle start pointer index error by checking if mid is zero and mid val is
   greater than the element to right, its a peak.
5. Handle end pointer index error by checking if mid is len(nums)-1 and mid val is
   greater than the element to left, its a peak.
   
'''







class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        low=0
        high=len(nums)-1
        
        while low<=high:
            
            mid=low+(high-low)//2
            
            if (mid==0 or nums[mid]>nums[mid-1])&(mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            else:
                if nums[mid]>nums[mid+1]:
                    high=mid-1
                else:
                    low=mid+1