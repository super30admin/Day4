# Time Complexity : O(lon n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def start():
            l=0
            u=len(nums)-1
            
            while l<=u:
                
                mid=(l+u)//2
                if nums[mid]<target:
                    l=mid+1
                else:
                    u=mid-1
                
            if l<len(nums) and nums[l]==target:
                return l
            else:
                return -1
        
        def end():
            l=0
            u=len(nums)-1
            
            while l<=u:
                
                mid=(l+u)//2
                if nums[mid]>target:
                    u=mid-1
                else:
                    l=mid+1
                
            if u<len(nums) and nums[u]==target:
                return u
            else:
                return -1
        if not nums:
            return [-1,-1]
        return (start(),end())
