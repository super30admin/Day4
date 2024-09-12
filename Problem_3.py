#LC 162
# Find Peak Element
# Time Complexity : O(log N)
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while low < high:
            mid = low +(high-low+1)//2  #to prevent infinite loop
            if nums[mid] < nums[mid-1]: # The last element for which this condition will be False 
                high = mid - 1
            else: # decrement so that peak will be before mid or it can be mid
                low = mid
        return low