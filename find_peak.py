class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low < high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] < nums[mid - 1]) and nums[mid] < nums[mid + 1]:
                return nums[mid]
            else:
                if nums[mid] > nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return nums[low]