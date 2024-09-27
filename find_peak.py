# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def findPeakElement(self, nums):
        left, right = 0, len(nums)-1
        while(left<right):
            m = (left+right)//2
            if nums[m] < nums[m+1]:
                left = m+1
            else:
                right = m
        return left
        