# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums) - 1
        lo = 0
        hi = n
        while lo <= hi:
            mid = (lo + hi) // 2
            if mid < n and nums[mid] > nums[mid + 1]:
                #Rotation point
                return nums[mid + 1]
            if nums[lo] > nums[mid]:
                hi = mid - 1
            else:
                lo = mid + 1
        # No rotation has been performed
        return nums[0] 