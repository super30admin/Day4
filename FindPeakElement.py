# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0

        arr_size = len(nums)
        end = arr_size - 1

        if start == end:
            return start

        while start <= end:
            mid = start + (end - start)//2
            if mid-1 >= 0 and mid+1 <= (arr_size - 1) and nums[mid - 1] <= nums[mid] and nums[mid+1] <= nums[mid]:
                return mid
            elif mid+1 <= arr_size-1 and nums[mid] < nums[mid+1]:
                start = mid + 1
            else:
                end = mid - 1
        return start
