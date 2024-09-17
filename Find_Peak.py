# Time Complexity : o(logn)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes

class Solution:
    def findPeakElement(self, nums) -> int:
        left, right=0,len(nums)-1
        while left<right-1:
            mid=(left+right)//2
            if nums[mid]>=nums[mid+1] and nums[mid]>=nums[mid-1]:    # termination condition for peak
                return mid
            if nums[mid+1]>nums[mid]:               # assuming that peak lies on the side of greater element as the probability increases 
                left=mid+1
            else:
                right=mid-1
        if nums[left]>=nums[right]:
            return left
        return right 