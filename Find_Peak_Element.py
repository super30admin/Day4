#// Time Complexity :O(logn)
#// Space Complexity :O(1)
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :no


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        while(l<r):
            mid=(l+r)//2 # searching towards the increasing half
            if(mid!=len(nums)-1 and nums[mid]<nums[mid+1]):
                l=mid+1
            else:
                r=mid
        return l