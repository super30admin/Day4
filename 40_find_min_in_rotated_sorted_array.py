# Time complexity - O(log n)
# Space complexity - O(1)
# Approach - Implement BS, keep going till mid element is less than both 
# [mid-1] and [mid+1] element

from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        if len(nums) == 1:
            return nums[0]
        
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + ((high - low) // 2)

            if nums[low] < nums[high]:
                return nums[low]

            if (mid == low or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid+1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1