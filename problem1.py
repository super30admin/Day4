# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]

        left = self.binarySearchLeft(nums, target)
        right = self.binarySearchRight(nums, target)
        return [left, right]

    def binarySearchLeft(self, nums: List[int], target: int):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = int(low + (high - low) / 2)
            if nums[mid] == target:
                # found the target now find left and right
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            # missed this if earlier
            else:
                if nums[mid] > target:
                    high = mid - 1
                else:
                    low = mid + 1

        return -1

    def binarySearchRight(self, nums: List[int], target: int):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = int(low + (high - low) / 2)
            if nums[mid] == target:
                # found the target now find left and right
                if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1
            else:
                if nums[mid] > target:
                    high = mid - 1

                else:
                    low = mid + 1

        return -1
