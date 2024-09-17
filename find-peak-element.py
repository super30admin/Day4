# Time complexity: O(log n)
# Space complexity: O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:      
        low = 0 
        n = len(nums)
        high = n - 1

        while low < high:
            mid = (low + high) // 2
            if nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid
        return low

