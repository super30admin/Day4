""""// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""





class Solution:
    def findPeakElement(self, nums):
        l=0
        r=len(nums)-1
        while l<=r:
            mid=l+(r-l)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid>0 and nums[mid]<nums[mid-1]:
                r=mid-1
            else:
                l=mid+1
        return -1
