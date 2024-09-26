class Solution:
    def findMin(self, nums: List[int]) -> int:
        if (not nums):
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) // 2
            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:

                low = mid + 1
            else:
                high = mid - 1
        return -1