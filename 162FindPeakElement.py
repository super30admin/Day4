class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low, high = 0, n - 1
        # if n == 1:
        #     return low
        while low < high:
            mid = low + (high - low) // 2
            # if low == mid and high == mid:
            #     return mid
            if nums[mid] > nums[mid + 1]:
                high = mid
            else:
                low = mid + 1

        return low