# Time Complexity = O(logn)
# Space Complexity = O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            # unsorted side which implies least element is present there
            if nums[mid] >= nums[high]:
                low = mid + 1
            else:
                high = mid
        return nums[mid]