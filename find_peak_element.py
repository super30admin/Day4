# // Time Complexity : # we will have O(logn) complexity
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def findPeakElement(self, nums):
        s=0
        e=len(nums)-1
        
        while s<=e:
            mid=(s+e)//2
            
            if (mid ==0 or nums[mid]> nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid==0 or nums[mid]> nums[mid-1]:
                #that means find peak on right
                s=mid+1
            else:
                #peak on left
                e=mid-1
        return -1
                