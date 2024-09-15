# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums or len(nums) == 0:
            return [-1, -1]

        if target < nums[0] or target > nums[len(nums) - 1]:
            return [-1, -1]

        first = self.binary_search_first(nums, target)
        if first == -1:
            return [-1, -1]

        last = self.binary_search_last(nums, target, first)

        return [first, last]

    # Returns the first index of target
    def binary_search_first(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if target == nums[mid]:
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid
                elif nums[mid - 1] == nums[mid]:
                    high = mid - 1

            elif target > nums[mid]:
                low = mid + 1

            else:
                high = mid - 1

        return - 1

    # Returns the last index of target
    def binary_search_last(self, nums: List[int], target: int, low: int) -> int:
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if target == nums[mid]:
                if mid == len(nums) - 1 or nums[mid + 1] > nums[mid]:
                    return mid
                elif nums[mid + 1] == nums[mid]:
                    low = mid + 1

            elif target > nums[mid]:
                low = mid + 1

            else:
                high = mid - 1

        return - 1

