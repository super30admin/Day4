# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:

        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums)-1

        while high >= low:
            mid = (low + high) // 2

            # if there is only one number return it or return the first element if the whole array is sorted
            if nums[low] <= nums[high]:
                return nums[low]

            # return the lowest element if found
            if nums[mid-1] > nums[mid] and nums[mid+1] > nums[mid]:
                return nums[mid]

            # move to the unsorted side to check for the element first to the left then to the right of it
            if nums[low] <= nums[mid]:
                low = mid+1
            else:
                high = mid-1

        return -1
