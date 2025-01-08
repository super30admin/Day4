# Time complexity - O(log n)
# Space complexity - O(1)
# Approach - Implement BS, keep going till mid element is greater than both 
# [mid-1] and [mid+1] element

from typing import List
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return -1
        
        if len(nums) == 1:
            return 0
        
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + ((high - low) // 2)

            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid+1]):
                return mid
            
            if mid == 0 or nums[mid - 1] < nums[mid]:
                low = mid + 1
            else:
                high = mid - 1