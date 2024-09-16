"""
For finding the minimum element we basically just need to find the pivot element of the array
Whichever side of mid is sorted, minimum will never be on that side because the aray is rotated sorted array
1. Find the sorted side
2. If rotated side is left then ignore it and move to right of mid
3. If rotated side is right then ignore it and move to left of mid
4. If mid is lower than mid-1 and mid+1 then minimum is mid, so return mid
"""

# Time complexity - O(log N)
# Space complexity - O(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """        
        if len(nums) == 0 or nums is None:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            mid = low + (high - low)/2
            
            if nums[low] < nums[high]:
                return nums[low]
            
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            
            # left side is sorted
            elif nums[low] <= nums[mid]:
                low = mid + 1
                
            # right side is sorted
            else:
                high = mid - 1 
                
        return -1
                                
            