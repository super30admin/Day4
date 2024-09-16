# Time Complexity: O(n)
# Space Complexity: O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not able to do using Binary search

# Code along with comments explaining the approach

class Solution(object):
    def searchRange(self, nums, target):
        # Check from left side
        for i in range(len(nums)):
            if nums[i]==target:
                left = i
                break
        else:
            return [-1,-1]
        
        # check from right side
        for j in range(len(nums)-1,-1,-1):
            if nums[j]==target:
                right = j
                break
        return [left,right]