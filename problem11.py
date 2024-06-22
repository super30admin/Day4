class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low) // 2  # Corrected integer division
            
            # Check if mid is a peak element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid
            elif mid > 0 and nums[mid] < nums[mid - 1]:
                # If the left neighbor is greater, then the peak is in the left half
                high = mid - 1
            else:
                # If the right neighbor is greater, then the peak is in the right half
                low = mid + 1
        
        return -1  # This line should never be reached