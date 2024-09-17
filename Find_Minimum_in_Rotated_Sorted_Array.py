#// Time Complexity :O(logn)
#// Space Complexity :O(1)
#// Did this code successfully run on Leetcode :yes
#// Any problem you faced while coding this :yes, learnt this process from sir.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        if(nums==[]):
            return -1
        if(len(nums)==1):
            return nums[0]

        while(l<=r):
            if(nums[l]<=nums[r]):
                return nums[l]
            
            mid=(l+r)//2
            if(nums[mid]<nums[mid+1] and nums[mid]<nums[mid-1]):
                return nums[mid]
            else:
                if(nums[l]<=nums[mid]):
                    l=mid+1        
                elif(nums[mid]<=nums[r]):
                    r=mid-1

        
        return -1
                
                
                