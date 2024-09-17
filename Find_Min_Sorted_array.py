# Time Complexity : o(logn)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        
        l=0
        h=len(nums)-1
        x=0
        while l<=h:
            m=(l+h)//2          
            if (nums[m]>nums[h]):       #unsorted subarray
                l=m+1
            else:                       #sorted 
                if nums[m]<nums[m-1]:   #termination condition for minimum
                    x=m
                    break
                else:
                    h=m-1
        return nums[x]