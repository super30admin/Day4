# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        start,end,n = 0,len(nums)-1,len(nums)
        while start<end:
            mid = (start+end)//2
            if nums[mid] > nums[mid+1]:
                end = mid
            else:
                start = mid+1
        return start
