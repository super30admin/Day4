# Find Peak Element

# Time Complexity : O(log 2 n) 
# Space Complexity : O(1) which is binary search complexity
# Did this code successfully run on Leetcode : Yes, with Runtime: 32 ms and Memory Usage: 13.5 MB
# Any problem you faced while coding this : Yes, Initially I was able to pass a single test case and than on
# trying for other test cases after code walkthrough was able to understand and solve.
# Your code here along with comments explaining your approach
# Approach
"""
After computing middle Since it is a binary Search approach to solve a problem requiring
logarithmic complexity Since neighbors are checked so dividing and checking 
if middle element is greater than its next element by reducing the search space in half at every step
we get the index of peak element.

"""
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        first_index=0 # Initializing first index as 0
        last_index=len(nums)-1 # Initializing last_index as lenght of list-1
        while(first_index<last_index): 
            middle=(first_index+last_index)//2  # Calculating pivot/middle value
            if (nums[middle]>nums[middle+1]):
                last_index=middle
            else:
                first_index=middle+1
        return first_index