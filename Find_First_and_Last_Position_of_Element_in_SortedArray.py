#// Time Complexity :O(logn)
#// Space Complexity :O(1)
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :partly yes, was not sure if my process was good enough. 

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l=0
        r=len(nums)-1
        index1=-1
        index2=-1
        if(nums==[]):
            return[-1,-1]
        #find out th 1st occurance index using binary search
        while(l<=r):
            m=(l+r)//2
            if(nums[m]==target):
                if(m==0 or nums[m]>nums[m-1]):
                    index1=m
                    break
                else:
                    r=m-1
            elif(nums[m]>target):
                r=m-1
            else:
                l=m+1
        #find out th last occurance index using binary search
        l=index1
        r=len(nums)-1
        while(l<=r):
            m=(l+r)//2
            if(nums[m]==target):
                if(m==len(nums)-1 or nums[m]<nums[m+1]):
                    index2=m
                    break
                else:
                    l=m+1
            elif(nums[m]>target):
                r=m-1
            else:
                l=m+1
        
        return [index1,index2]