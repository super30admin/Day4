# Time Complexity : O(log(n)) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Approach:
#1. We will use binary search. This is the iterative solution for binary search.
#2. We check if the mid element of the array is peak element by comparing it with its neighbors, if it is, we return its index or else, we take that part of the 
# array towards which we see a larger element than the mid.
#3. If both the left and right neighbors are larger, any of the sub array can be taken for next iteration.


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, len(nums)-1
        
        while start <= end:
            mid = start + (end - start) // 2
            
            if (mid == 0 or nums[mid-1] < nums[mid]) and ( mid == len(nums) - 1 or nums[mid] > nums[mid+1]):
                return mid
            if nums[mid] < nums[mid+1]:
                start = mid + 1
            else:
                end = mid - 1
        return -1
