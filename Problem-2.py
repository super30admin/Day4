# Time Complexity : O(log(n)) for all operations
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l =0
        r = len(nums)-1
        
        while l<=r:
            m = l + (r-l)//2
            
            if (m==0 or nums[m]<nums[m-1]) and (m==len(nums)-1 or nums[m]<nums[m+1]):
                return nums[m]
            if nums[m]<nums[r]:
                r = m-1
            else:
                l=m+1
        
        return -1