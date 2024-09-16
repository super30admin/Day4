# Time Complexity: O(log(n))
# Space Complexity: O(1)

class Solution:
    def findPeakElement(self, nums):
        if len(nums) == 0:
            return
        
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high -low) // 2
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) -1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid == len(nums) -1 or nums[mid + 1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

