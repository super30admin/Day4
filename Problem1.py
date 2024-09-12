class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        high = len(nums) - 1
        low = 0
        start = -1
        end = -1
        if (len(nums) == 0):
            return [-1, -1]
        while (low <= high):
            mid = int(low + (high - low) / 2)

            if (nums[mid] > target and nums[low] < target):
                high = mid - 1
            elif (nums[mid] < target and nums[high] > target):
                low = mid + 1
            else:
                return [self.low_index(nums, 0, mid, target), self.high_index(nums, mid, len(nums) - 1, target)]

    def low_index(nums, low, high, target):
        while (low < high):
            mid = int((high - low) / 2)
            if (nums[mid] < target):
                low = mid + 1
            elif (nums[mid - 1] < target):
                return mid
            else:
                high = mid - 1
        return low

    def high_index(nums, low, high, target):
        while (low < high):
            mid = int((high - low) / 2)
            if (nums[mid] > target):
                high = mid - 1
            elif (nums[mid + 1] > target):
                return mid
            else:
                low = mid + 1
        return high


