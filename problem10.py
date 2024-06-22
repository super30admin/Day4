class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            # If the subarray is already sorted, return the first element
            if nums[low] <= nums[high]:
                return nums[low]
            
            mid = low + (high - low) // 2
            
            # Check if the mid element is the minimum element
            if mid > 0 and nums[mid] < nums[mid - 1]:
                return nums[mid]
            elif nums[low] <= nums[mid]:
                # If the left half is sorted, the minimum must be in the right half
                low = mid + 1
            else:
                # If the right half is sorted, the minimum must be in the left half
                high = mid - 1
                
        return -1  # This line should never be reached if the input is a rotated sorted array