class Solution:
    def binarySearch_Left(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2  # to avoid interger overflow
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:  # checking the edge cases at the START of the array
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarySearch_Right(self, nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low)
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:  # checking the edge cases at the END of the array
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0: return [-1, -1]
        if nums[0] > target or nums[len(nums) - 1] < target: return [-1, -1]
        first = self.binarySearch_Left(nums, target)
        if first == -1: return [-1, -1]
        last = self.binarySearch_Right(nums, target)
        return [first, last]
