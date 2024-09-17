"""
Intuition: We have to the get the index of the peak element.

A peak will always be higher that its neighbours.

If a neighbour is high, go to that neighbours direction.
If both neighbours are high, go any direction.
#####################################################################
Time Complexity : O(logn) where n = number of elements
Space Complexity : O(1)
#####################################################################

"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        
        low = 0
        high = len(nums) -1
        
        while low <= high:
            
            mid = (low + high) //2

            #Got the peak element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums)-1 or nums[mid] > nums[mid + 1]):
                return mid
            
            #Neighbour is higher than current element
            if nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid -1
        
        return