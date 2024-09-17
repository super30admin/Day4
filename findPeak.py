'''
Applying BS:
1. Find mid
2. check if it is greater than all of its neighbours
    3. If yes, return mid
    else: move on the side of mid where the neighbouring element is greater.
    If both neighbours are greater, move to either side

Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Did not considered boundary conditions
in the second if condition.(elif part)
'''


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        low = 0
        high = len(nums) - 1
        
        if nums == None or len(nums) == 0:
            return -1
        while low <= high:
            mid = low + (high-low) / 2
            
            if (mid == low or nums[mid] > nums[mid-1]) and (mid == high or nums[mid] > nums[mid+1]):
                return mid
            elif mid !=high and nums[mid]<nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
                