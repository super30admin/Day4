# Time complexity : O(log n)
# Space complexity : O(1)
# Leetcode: Solved and submitted

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
      
        # Initializing the default values
        low = 0
        high = len(nums) - 1
        
        # iterating from low to high
        while low < high:
            mid = low + (high - low) // 2
            
            # checking for elements which is higer, and accordingly get the search space until we find the peak
            if nums[mid] > nums[mid+1]:
                high = mid
            else:
                low = mid + 1
        return low
           
        '''
        for i in range(len(nums)-1):
            if nums[i] > nums[i+1]:
                return i
        return len(nums)-1
        '''
