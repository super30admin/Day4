# Time Complexity O(logn)
# Space Complexity O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.binarySearch(nums, target, "left"), self.binarySearch(nums, target, "right")]

    def binarySearch(self, nums, target, bias):
        left = 0
        right = len(nums) - 1
        i = -1

        while left <= right:
            mid = left + (right - left) // 2

            if target < nums[mid]:
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1
            else:
                i = mid
                if bias == "left":
                    right = mid - 1
                elif bias == "right":
                    left = left + 1

        return i
