# Find Minimum in Rotated Sorted Array

# Time Complexity : O(log n) which is binary search complexity
# Space Complexity : O(1) which is binary search complexity
# Did this code successfully run on Leetcode : Yes, with Runtime: 24 ms and Memory Usage: 13.8 MB
# Any problem you faced while coding this : Yes, Initially I was decrementing last_index but than 
# after checking failed case I walked through code to make correction.
# Your code here along with comments explaining your approach
# Approach
"""
In Binary Search list is divided into two halves after calculating the middle value
and than element is searched for. In this problem minimum element is to be found and rotation is by
shifting element at last_index so element at middle is compared with element at last_index
if it is greater minimum is found in right half and first_index is shifted
else if smaller than last_index is set to be the middle value.
  
"""
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        first_index=0 # Initializing first index as 0
        last_index=len(nums)-1 # Initializing last_index as lenght of list-1
        while (first_index <= last_index):
            middle=(first_index+last_index)//2 # Calculating pivot/middle value
            if(nums[middle]>nums[last_index]): # greater minimum is found in right half
                first_index=middle+1 
            elif (nums[middle]<nums[last_index]):
                last_index=middle
            else:
                return nums[last_index] 
        return nums[first_index]