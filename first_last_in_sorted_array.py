
# Time Complexity : log(n)
# Space Complexity : log(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def searchfirst(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + ((high - low) // 2)
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != target:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def searchlast(self, nums: List[int], target: int, first: int) -> int:
        low = first
        high = len(nums) - 1
        while low <= high:
            mid = low + ((high - low) // 2)
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] > target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or nums is None or nums[0] > target or nums[len(nums) - 1] < target:
            return [-1, -1]
        first = self.searchfirst(nums, target)
        last = self.searchlast(nums, target, first)
        return [first, last]

