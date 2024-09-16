"""
    we check the mid element with mid-1 and mid+1 
    this will compare if the mid is greater than it's neighbors
    In that case we will return mid
    Else we will check to see if mid+1/mid-1 > mid and move our low/high pointers
    to that side of the array. Peak will definitely be on the side that is greater 
"""
# time complexity - O(log N)
# space complexity - O(1)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums) == 0 or nums is None:
            return -1
        
        low = 0
        high = len(nums)
        
        while low <= high:
            mid = low + (high - low)/2
            
            # if mid is greater than mid-1 and mid+1
            # also checking for array out of bound exception
            if (mid == len(nums)-1 or nums[mid] > nums[mid+1]) and (mid == 0 or nums[mid] > nums[mid-1]):
                return mid

            # mid+1 > mid will mean move the low pointer to mid+1
            elif mid != len(nums)-1 and nums[mid+1] > nums[mid]:
                low = mid + 1

            # mid-1 > mid so move high pointer to mid-1 because peak is on the left side
            else:
                high = mid - 1
        
        return mid