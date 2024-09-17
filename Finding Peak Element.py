class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1: return 0
        if nums[0] > nums[1]: return 0
        if nums[len(nums) - 1] > nums[len(nums) - 2]: return len(nums) - 1

        low, high = 0, len(nums) - 1

        while (low <= high):
            mid = low + (high - low) // 2
            if nums[mid - 1] < nums[mid] and nums[mid] > nums[mid + 1]:
                return mid
            elif nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

