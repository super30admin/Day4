#   ques: 153. Find Minimum in Rotated Sorted Array

#   Time Complexity :
#   O(log n)

#  Space Complexity :
#  O(1)

#  Did this code successfully run on Leetcode :
#  Yes

#  Any problem you faced while coding this :
#  No

#  Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if (nums is None) or (len(nums) == 0):
            return -1
        
        low, high = 0, len(nums) - 1
        
        # Applying Binary Search
        while(low <= high):
            # Checking if array is already sorted
            # If it is sorted return first element 
            if nums[low] <= nums[high]: return nums[low] 
            
            mid = (low+high)//2
            
            # Checking if mid element is minimum
            # If it is minimum return mid element
            if (mid==0 or nums[mid] < nums[mid-1]) and (mid==len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            # Checking if left side side is sorted, if it is sorted we will find minimum in right side that is unsorted side.
            elif nums[low] <= nums[mid]:
                low = mid + 1
            # If left side is not sorted we will find minimum in left side that is unsorted side.
            else:
                high = mid - 1