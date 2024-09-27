class Solution:

    def first_index(self, nums, target, low, high):
        low = 0
        high = len(nums) - 1

        # first find the target
        while (low <= high):
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if (mid == 0 or nums[mid - 1] < target):
                    return mid
                else:
                    high = mid - 1

            # normal binary search
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

    def last_index(self, nums, target, low, high):

        # first find the target
        while (low <= high):
            mid = low + (high - low) // 2

            if nums[mid] == target:
                if (mid == len(nums) - 1 or nums[mid + 1] > target):
                    return mid
                else:
                    low = mid + 1

            # normal binary search
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1

        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:

        first_loc = self.first_index(nums, target, 0, len(nums) - 1)
        last_loc = self.last_index(nums, target, 0, len(nums) - 1)
        return [first_loc, last_loc]



