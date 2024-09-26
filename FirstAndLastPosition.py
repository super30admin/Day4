# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# To find first position we'll find the element using binary search first, then when we find it then we'll try to 
# find it again to the left of current position. Thus at the end we'll have found the first position
# Same for last position.

from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l=0
        r=len(nums)-1
        f1=self.findFirstIndex(nums,l,r,target)
        f2=self.findLastIndex(nums,l,r,target)
        return [f1,f2]
        
    def findFirstIndex(self,nums,l,r,target):
        res=-1
        while l<=r:
            mid=(r+l)//2
            if nums[mid]==target:
                res=mid
                r=mid-1
            elif nums[mid]>target:
                r=mid-1
            else:
                l=mid+1
        return res
    
    def findLastIndex(self,nums,l,r,target):
        res=-1
        while l<=r:
            mid=(r+l)//2
            if nums[mid]==target:
                res=mid
                l=mid+1
            elif nums[mid]>target:
                r=mid-1
            else:
                l=mid+1
        return res
    
#         while l<=r:
#             mid=(r+l)//2
#             if nums[mid]==target:
#                 f1=mid-1
#                 f2=mid+1
#                 while f1>=0 and nums[f1]==target:
#                     f1-=1
#                 f1+=1
#                 while f2<=(len(nums)-1) and nums[f2]==target:
#                     f2+=1
#                 f2-=1
                
#             if nums[mid]<target:
#                 l=mid+1
#             else:
#                 r=mid-1
                
    
                