# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def findPeakElement(self, nums):
        l, r = 0, len(nums)-1
        while(l<r):
            m = (l+r)//2
            if nums[m] < nums[m+1]:
                l = m+1
            else:
                r = m
        return l
        