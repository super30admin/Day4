# Time Complexity : O(lon n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, However after getting online help i understood my mistake where I was stuck


# Your code here along with comments explaining your approach
	#find middle element and compare with next right side element to find peek value
	
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l=0
        u=len(nums)-1
        
        while l<u:
            mid=(l+u)//2
            
            if nums[mid]<nums[mid+1]:
                l=mid+1
            else:
                u=mid
        return l
        
