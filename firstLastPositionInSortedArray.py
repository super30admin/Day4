from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        low = 0
        high = len(nums) - 1

        def returnFirst(low, high):
            result1 = -1
            while low <= high:
                mid = (low + high) >> 1

                if nums[mid] == target:
                    result1 = mid
                    high = mid - 1
                    continue

                if nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1
            return result1

        def returnLast(low, high):
            result2 = -1
            while low <= high:
                mid = (low + high) >> 1

                if nums[mid] == target:
                    result2 = mid
                    low = mid + 1
                    continue

                if nums[mid] < target:
                    low = mid + 1
                else:
                    high = mid - 1
            return result2

        num1 = returnFirst(0, len(nums) - 1)
        num2 = returnLast(0, len(nums) - 1)

        return [num1, num2]
