// Time Complexity :o(logn)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution(object):
    def findMin(self, nums):
        l=0
        r=len(nums)-1
        if(nums[r]>=nums[0]):
            return nums[0]
        while(l<=r):
            mid=(l+r)//2
            if(nums[mid]<nums[mid-1]):
                return nums[mid]
            if(nums[mid]>nums[mid+1]):
                return nums[mid+1]
            if(nums[mid]>nums[0]):
                l=mid+1
            else:
                r=mid-1
