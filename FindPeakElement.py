# The approach uses binary search to find a peak element in O(log n) time.
# It checks the middle element to see if it is greater than its neighbors and adjusts the search range accordingly.
# The algorithm stops when a peak element is found or when the search space is reduced to one element.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1
        
        while low < high:
            mid = low + (high - low) // 2
            
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
        
        return low  # When low == high, we found the peak element
