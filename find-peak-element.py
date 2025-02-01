# The code performs a binary search to find a peak element in the given array.
# It compares the middle element with its right neighbor to determine whether the peak lies to the left or right.
# The search space is narrowed based on the comparison until a peak element is found.
# Time Complexity: O(log n)
# Space Complexity: O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low < high:
            mid = (low + high) // 2
            if nums[mid] > nums[mid + 1]:
                high = mid
            else:
                low = mid + 1
        return low