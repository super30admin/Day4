# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:

    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid - 1 < low or nums[mid - 1] < target:
                    return mid
                else:
                    high = mid - 1

            elif nums[mid] < target:
                low = mid + 1

            else:
                high = mid - 1

        return -1

    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if mid + 1 > high or nums[mid + 1] > target:
                    return mid
                else:
                    low = mid + 1

            elif nums[mid] < target:
                low = mid + 1

            else:
                high = mid - 1

        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        if nums == [target]:
            return [0, 0]

        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        last = self.binarySearchLast(nums, target)

        return [first, last]
