"""

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

"""

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def findFirstOccurrence(nums, target):
 
            # Declating an array with start and end
            (left, right) = (0, len(nums) - 1)
        
            # First initializing result1 to -1 as per constraint
            result1 = -1
        
            # Running binary search until result1 is found
            while left <= right:
        
                # setting up the mid
                mid = (left + right) // 2
        
                # if target found at target, store value in result 1 and set the boundary for 
                # the left side of the array (high = mid - 1)
                # (now we only need to search right part to see if result2 location can also be found)
                if target == nums[mid]:
                    result1 = mid
                    right = mid - 1
        
                # if target is smaller than mid, no need of right side of array
                elif target < nums[mid]:
                    right = mid - 1
        
                # if target is bigger than mid, no need of left side of array
                else:
                    left = mid + 1
        
            # return the leftmost index, or -1 if the element is not found
            return result1


        # Same step to find second lcoation in result 2
        def findSecondOccurrence(nums, target):
 
            # set start and end boundry again
            (left, right) = (result1, len(nums) - 1)
        
           
            result2 = -1
        
            # Binary search once again
            while left <= right:
        
                mid = (left + right) // 2
        
                if target == nums[mid]:
                    result2 = mid
                    left = mid + 1
        
                elif target < nums[mid]:
                    right = mid - 1

                else:
                    left = mid + 1
        
            return result2

        # calling respective functions to know first and second position
        start = findFirstOccurrence(nums, target)
        end = findSecondOccurrence(nums, target)

        # ensuring start and end conditions match and we have found results
        if 0 <= start < len(nums) and start <= end and nums[start] == target:
            return [start, end]
        else:
            return [-1, -1]
        
s = Solution()
nums = [ 2, 3, 4, 10, 10, 40 ] 
x = 10
  
# Function call 
result = s.searchRange(nums, x) 
print(result)