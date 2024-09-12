"""
Time Complexity: O(logn)
Space Complexity: O(1)
Compiled on leetcode: Yes
Difficulties faced: No
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0 
        high = len(nums)
        while low <= high:
            mid = (low + high) // 2
            if mid + 1 >= len(nums):
                rightElement = float('-inf')
            else:
                rightElement = nums[mid + 1]
            if mid - 1 < 0:
                leftElement = float('-inf')
            else:
                leftElement = nums[mid - 1]
            
            if nums[mid] > leftElement and nums[mid] > rightElement:
                return mid
            elif leftElement < rightElement:
                low = mid + 1
            else:
                high = mid - 1
            