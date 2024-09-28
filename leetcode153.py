# Time Complexity : O(lon n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        l=0
        u=len(nums)-1
        
        if nums is None:
            return 0
        
        while l<=u:
            
            mid=(l+u)//2
            
            if nums[mid]>nums[u]:
                l=mid+1
                if nums[l]<nums[u]:
                    return nums[l]
            elif nums[mid]<nums[u]:
                u=mid
                if nums[l]<=nums[u]:
                    return nums[l]
            else:
                return nums[u]
        return 0
                
