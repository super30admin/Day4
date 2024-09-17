class Solution(object):
    def searchRange(self, nums, target):

        low, high = 0, len(nums) - 1
        first = self.findFirstIndex(nums, low, high, target)
        second = self.findLastIndex(nums, low, high, target)
        return [first, second]

    def findFirstIndex(self, nums, low, high, target):
        default = -1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                default = mid
                high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return default

    def findLastIndex(self, nums, low, high, target):
        default = -1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                default = mid
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return default