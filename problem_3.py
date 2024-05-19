# Time complexirt O(logN)
# Space complexity O(1)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1 
        low, high = 0 , len(nums) - 1
        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid 
        return low
        