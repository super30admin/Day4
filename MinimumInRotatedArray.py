# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# If middle element is bigger than the tight boundary element, then that means that at some point between mid and
# right, the array got rotated. So the minimum element has to lie to the right. When left and right will converge
# then we'll find the start of array if it were unsorted i.e the smallest element.
from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
  
    # when this loop ends, left and right will converge upon the minimum element
        while l<r:                  
            mid=(l+r)//2
            if nums[mid]>nums[r]:
                l=mid+1
            else:
                r=mid
        return nums[l]
                