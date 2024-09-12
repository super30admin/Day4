# Time Complexity : O(lgN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes. I had to take care and 
# consider the case of the peak being at either ends of the list.



# Your code here along with comments explaining your approach

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        """
        to be a peak.. it must be bigger than it's neighbors. Can do binary search.
        However, we determine the left/right values based on if for example, the right side of the mid/pivot val
        is smaller, then we want to go search the right side..left otherwise.
        """
        
        left = 0 
        right = len(nums)-1
        
        while left <= right:
            mid = left + (right-left)//2
            
            #edge case!! what if you are at either end of the list?
                #this is what checks and takes care of it
            if (mid == len(nums)-1 or nums[mid] > nums[mid+1]) and (nums[mid] > nums[mid-1] or mid == 0):
                return mid
            #if right side of mid is smaller, search right side/ else the opposite
            elif nums[mid] < nums[mid+1]:
                left = mid + 1
            else:
                right = mid - 1
                
                