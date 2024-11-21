# Time Complexity : log(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : yes, was forsgetting to take mid!=0 in  elif(mid!=0 and nums[mid-1]>nums[mid]):

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        if len(nums)==1:
            return 0
        
        while low<=high:
            mid=low+(high-low)//2
            if (mid==0 and nums[mid]>nums[mid+1]) or (mid==len(nums)-1 and nums[mid-1]<nums[mid] ) or (nums[mid-1]<nums[mid] and nums[mid]>nums[mid+1]):
# if (mid==low and nums[mid]>nums[mid+1]) or (mid==high and nums[mid-1]<nums[mid] ) or (nums[mid-1]<nums[mid] and nums[mid]>nums[mid+1]): sol given by Jaspinder
                return mid
            elif(mid!=0 and nums[mid-1]>nums[mid]):
                high=mid-1
            elif(nums[mid]<nums[mid+1]):
                low=mid+1
            
        return low