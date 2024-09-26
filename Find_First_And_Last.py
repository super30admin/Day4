class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or nums[0] > target or target > nums[-1]:
            return [-1, -1]
        if len(nums) == 1:
            return [0, 0]
        low = 0
        high = len(nums) - 1

        first = self.binarysearchfirst(nums, low, high, target)
        if first == -1:
            return [-1, -1]

        second = self.binarysearchsecond(nums, first, high, target)

        return [first, second]

    def binarysearchfirst(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            print(mid)
            if nums[mid] == target:
                if nums[mid - 1] < target or mid == 0:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def binarysearchsecond(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] > target:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1