# Time Complexity = O(log n)
# Space Complexity = O(1)

class Solution(object):
    def searchRange(self, nums, target):

        low = 0
        high = len(nums) - 1
        first = -1
        last = -1

        if len(nums) == 0:
            return [first, last]

        while low <= high:
            mid = low + (high - low) / 2

            if nums[mid] > target:
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                first = mid
                high = mid - 1
        if first == -1:
            return [first, last]

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) / 2

            if nums[mid] > target:
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                last = mid
                low = mid + 1
        return [first, last]