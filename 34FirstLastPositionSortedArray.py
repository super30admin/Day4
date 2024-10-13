class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        first, last = -1, -1
        first = self.binarySearch(nums, target, low, high, 'left')
        last = self.binarySearch(nums, target, low, high, 'right')
        return [first, last]

    def binarySearch(self, nums: List[int], target: int, low: int, high: int, side: str) -> List[int]:
        result = -1
        while low <= high:
            mid = low + (high - low) // 2
            # print(mid)
            if target == nums[mid]:
                result = mid
                if side == 'left':
                    high = mid - 1
                elif side == 'right':
                    low = mid + 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return result

