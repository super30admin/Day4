# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n=len(nums)
        low=0
        high=n-1
        while(low<=high):
            mid=(low+high)//2

            if nums[mid]>=nums[high]:
                low=mid+1

            else:
                high=mid
                
        return nums[mid]