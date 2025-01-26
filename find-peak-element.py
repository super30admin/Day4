# Time complexity : O(log n)
# Space complexity : O(n)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        low = 0
        high = n-1
        while low <= high:
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == n-1 or nums[mid+1] < nums[mid]):
                return mid
            if mid > 0 and nums[mid] < nums[mid-1]:
                high = mid-1
            else:
                low = mid+1
        return 0  