 // Time Complexity :o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes i have done it with brute force but i have to do it with binary serach.
class Solution(object):
    def findPeakElement(self, nums):
        if(len(nums)==0):
            return -1
        if(len(nums)==1):
            return 0
        if(nums[0]>nums[1]):
            return 0
        if(nums[-1]>nums[-2]):
            return len(nums)-1
        for i in range(1,len(nums)-1):
            if(nums[i]>nums[i+1] and nums[i]>nums[i-1]):
                return i
                
