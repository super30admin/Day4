# Leetcode submission successful
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # logarithmic time so Binary Search

        # If array is already sorted in ascending order, first element will be the minimum.
        if nums[0] < nums[-1]:
            return nums[0]

        lo = 0
        hi = len(nums) - 1

        # Check if an element is smaller than its adjacent elements.
        while (lo <= hi):
            mid = lo + (hi - lo) / 2  # to prevent integer overflow
            if lo == mid and mid == hi:
                return nums[mid]
            if (nums[mid] < nums[mid - 1] and mid != 0) and (nums[mid] < nums[mid + 1] and mid != (len(nums) - 1)):
                return nums[mid]
            if nums[lo] <= nums[mid]:
                if nums[lo] < nums[lo - 1] and nums[lo] < nums[lo + 1]:
                    return nums[lo]
                lo = mid + 1
            else:
                hi = mid - 1