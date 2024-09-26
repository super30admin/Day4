# SC- O(logn)
# TC-O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        startpoint = self.start_point(nums, target)
        if startpoint == -1:
            return [-1, -1]
        endpoint = self.end_point(nums, target)
        return [startpoint, endpoint]

    def start_point(self, nums: List[int], target: int):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) // 2
            if (nums[mid] == target):
                if (mid == 0 or nums[mid - 1] != target):
                    return mid
                high = mid - 1
            elif (nums[mid] > target):
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def end_point(self, nums: List[int], target: int):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) // 2
            if (nums[mid] == target):
                if (mid == len(nums) - 1 or nums[mid + 1] != target):
                    return mid
                low = mid + 1
            elif (nums[mid] > target):
                high = mid - 1
            else:
                low = mid + 1
        return -1

