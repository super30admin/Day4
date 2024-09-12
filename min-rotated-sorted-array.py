# Time Complexity : O(log(n)) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Approach:
#1. We will use binary search. This is the iterative solution for binary search.
# We know that pivot element is the minimum element in the sorted array.
#2. For the pivot element, both the left and right neighbors have to be larger than the pivot element, if it's not at the corners of the array.
#. Applying this approach, we check if it's the leftmost element or smaller than left neighbor and rightmost or smaller than the right neighbor.

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, len(nums)-1
        
        while start <= end:
            mid = start + (end - start) // 2
            
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums) - 1 or nums[mid+1] > nums[mid]):
                return nums[mid]
            if nums[mid] < nums[end]:
                end = mid - 1
            else: start = mid + 1
        return -1
