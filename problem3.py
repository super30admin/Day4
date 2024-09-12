# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1
        
        while l <= h:
            m = l + (h-l)//2
            
            if (m == 0 or nums[m-1] < nums[m]) and (m == len(nums) - 1 or nums[m+1]<nums[m]):
                return m
            elif m < len(nums) - 1 and nums[m+1] > nums[m]:
                l = m+1
            else:
                h = m-1
                
        return -1