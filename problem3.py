# Time Complexity : O(log(n))
# Space Complexity : O(1)

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach

#Binary Search Approach


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        l, r = 0, len(nums)-1
        if nums[l] > nums[l+1]:
            return l
        if nums[r] > nums[r-1]:
            return r
        while l<r:
            m = (l+r)//2
            if nums[m-1]<nums[m] and nums[m]>nums[m+1]:
                return m
            elif nums[m-1]>nums[m]:
                r = m
            else:
                l = m+1    
        return l