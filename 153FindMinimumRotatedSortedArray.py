class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1

        while low < high:
            mid = low + (high - low) //2
            if nums[high] > nums[mid]:
                high = mid
            else:
                low = mid + 1
        return nums[low]
