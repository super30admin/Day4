# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        low = 0
        high = len(nums) - 1

        # checking peak element

        while low <= high:
            mid = (low + high) // 2
            # checking the extreme left of index and also checking the extreme right of index
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
                return mid
            # checking if low is greater than mid then move towards the right side else the left side
            elif nums[mid + 1] > nums[mid]:
                low = mid + 1

            else:
                high = mid - 1

        return -1
