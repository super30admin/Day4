# Time Complexity = O(logn)
# Space Complexity = O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1

        low, high = 0, len(nums) - 1

        while low <= high:
            mid = (low + high) // 2

            if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid+1] < nums[mid]):
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid-1
        
        return -1