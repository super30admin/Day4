# Time Complexity : O(log(n)) for all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        r = len(nums)-1
        while l<=r:
            m = l+(r-l)//2            
            if (m==0 or nums[m]>nums[m-1]) and (m==len(nums)-1 or nums[m]>nums[m+1]):
                return m 
            # if m=0 and m in not peak([2,1]) better check m+1 rather than m-1         
            if (nums[m+1]>nums[m]):
                l= m+1
            else:
                r = m-1
        return -1
            
        