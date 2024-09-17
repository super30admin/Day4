'''
IMP: pivot element will always be the minimum element.
Pivot will always lie in the non-sorted part of the array.
Applying BS:
1. First check whether mid is the minimum element: smaller than both neighbours.
2. Find the non-sorted part of the array and return its low value element. (Since pivot will
be in non-sorted part)
Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
'''
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if nums == None or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            if nums[low] < nums[high]:
                return nums[low]
            mid = low + (high - low) / 2
            if (mid == low or nums[mid] < nums[mid - 1]) and (
                    mid == high or nums[mid] < nums[mid + 1]):  # checking if mid element is min
                return nums[mid]
            elif nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid - 1
