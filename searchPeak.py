# Leetcode 1162. Find Peak Element

# Time Complexity :  O(log n) where n is the size of the array

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Condition: If both the neighbours are lesser than the current then its the min.
# If the mid element is not a peak than move in the direction of the neighbour with higher value to find the peak

# Your code here along with comments explaining your approach

class Solution:
    
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        while low<= high:
            mid = low + ((high-low)//2)
            
            # if mid points to the 0th index or the element BEFORE mid is less than mid
            # and if mid points to the last index or the element AFTER mid is less than mid
            if ((mid==0 or nums[mid-1]<nums[mid]) and ( mid == len(nums)-1 or nums[mid+1]<nums[mid])):
                return mid
            
            # IF mid is not the peak than move in the direction of the greater neighbour
            if nums[mid+1]>nums[mid]:
                low = mid+1
            else:
                high = mid - 1
        return -1