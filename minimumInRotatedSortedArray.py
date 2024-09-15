from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        low = 0
        high = len(nums) - 1

        if nums[low] < nums[high]:
            return nums[low]

        while low <= high:
            mid = (low + high) >> 1

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]

            if nums[mid - 1] > nums[mid]:
                return nums[mid]

            if nums[mid - 1] > nums[0]:
                low = mid + 1
            else:
                high = mid - 1
        return
