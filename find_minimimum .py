"""
Time Compexity: O(logn)
Sace Complexity: O(1)
"""


class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
    
        while left <= right:
            mid = (left + right) // 2

            if nums[left] <= nums[right]:
                return nums[left]

            if mid != 0 and nums[mid] < nums[mid-1]:
                return nums[mid]
            
            # If the middle element is greater than the rightmost element
            if nums[mid] >= nums[right]:
                # The minimum element must be in the right half
                left = mid + 1
            else:
                # The minimum element is in the left half including mid
                right = mid - 1
        
        return nums[left]
            