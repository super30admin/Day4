# Time Complexity : O(logN)
# Space Complexity : O(1) as no extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Took me a little while to understand 
# the change in the  logic of binary search

class Solution:

    def peakElement(self, nums) -> int:

        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            if lo == hi:
                return lo
            mid = (lo + hi) // 2
            if nums[mid] < nums[mid+1]:
                lo = mid + 1
            else:
                hi = mid

nums = [1,2,1,3,5,6,4]
obj = Solution()
print(obj.peakElement(nums))