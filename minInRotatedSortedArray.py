"""
Time complexity: O(logn)
Space complexity: O(1)
Compiled on leetcode: Yes
Difficulties faced: No
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = (low + high) // 2
            if mid + 1 >= len(nums):
                rightElement = float('inf')
            else:
                rightElement = nums[mid + 1]
            if mid - 1 < 0:
                leftElement = float('inf')
            else:
                leftElement = nums[mid - 1]
            if nums[mid] < leftElement and nums[mid] < rightElement:
                return nums[mid]
            elif nums[mid] > nums[high] and nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1