# The approach uses binary search to achieve O(log n) complexity. 
# It checks if the array or subarray is already sorted, in which case the first element is the minimum. 
# Otherwise, it adjusts the search bounds by comparing the middle element with the last element.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low < high:
            mid = low + (high - low) // 2
            
            if nums[low] < nums[high]:
                return nums[low]
            
            if nums[mid] > nums[high]:
                low = mid + 1
            else:
                high = mid
        
        return nums[low]
