// Time Complexity :O(logn)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution(object):
    def searchRange(self, nums, target):
        l=0
        r=len(nums)-1
        res=[]
        while(l<=r):
            mid=l+(r-l)/2
            if(nums[mid]<target):
                l=mid+1
            else:
                r=mid-1
        res.append(l)
        l=0
        r=len(nums)-1
        while(l<=r):
            mid=l+(r-l)/2
            if(nums[mid]>target):
                r=mid-1
            else:
                l=mid+1
        res.append(r)
        if(res[0]>res[1]):
            return[-1,-1]
        else:
            return res
            
                
                
                
            
            
        
