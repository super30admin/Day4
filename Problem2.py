"""
153. Find Minimum in Rotated Sorted Array
Time Complexity - O(logn)
Space Complexity - O(1)
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while(low <= high):
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[mid] > nums[high]:
                low = mid+1
            else:
                high = mid-1
        
        return -1