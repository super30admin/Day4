class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low) // 2
            # left neighbor is greater
            if mid > 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            # right neighbor is greater
            elif mid < n - 1 and nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                return mid
            