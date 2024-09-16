# Time Complexity:- O(log(n))
# Space Complexity:- O(1)
# Idea:- The low,mid and hi boundary dont tell us where to look, just find the mid ,check if mid<hi,
# if it is check if mid+1 is increasing if it is there is chance that we will find peak on the right
# else we will find a peak on the left
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low=0
        hi=len(nums)-1
        while(low<hi):
            mid=(low+hi)>>1
            if mid<hi and nums[mid]<nums[mid+1]:
                low=mid+1
            else:
                hi=mid
        return low