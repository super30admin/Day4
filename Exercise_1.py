"""
Time Complexity:    O(log(n))
Space Complexity:   O(1)
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am using binary search to search the target,
first we find the very first target index which is to the left then we find the right target index.
"""
class Solution:
    def left(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if nums[mid - 1] != target or mid == 0:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def right(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == (len(nums) - 1) or nums[mid + 1] != target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        if target < nums[0] or target > nums[len(nums) - 1]:
            return [-1, -1]
        left = self.left(nums, target)
        if left == -1:
            return [-1, -1]
        right = self.right(nums, target)
        return [left, right]



