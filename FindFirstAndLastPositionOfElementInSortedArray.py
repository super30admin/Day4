# The approach uses binary search twice to find the first and last occurrences of the target.
# The first binary search checks for the leftmost position, and the second checks for the rightmost position.
# This ensures an O(log n) runtime by narrowing the search space in a sorted array.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        
        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        
        last = self.binarySearchLast(nums, target)
        return [first, last]

    def binarySearchFirst(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != target:
                    return mid
                high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def binarySearchLast(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] != target:
                    return mid
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
