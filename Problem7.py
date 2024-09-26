# 34. Find First and Last Position of Element in Sorted Array.

# Time Complexity : O(log n) which is binary search complexity
# Space Complexity : O(1) which is binary search complexity
# Did this code successfully run on Leetcode : Yes, with Runtime: 64 ms and Memory Usage: 14.3 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
Find target using Binary Search 
There are two choices finding first occurence and last occurence.
On figuring the sorted portion, find the element if it lies in the range otherwise move further
"""

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def first_occurence(nums,target,first_index,last_index):
            if first_index > last_index: 
                return -1
            while(first_index<=last_index):
                middle=(first_index+last_index)//2
                if(target==nums[middle]):
                    if(middle==first_index or nums[middle-1]< target):
                         return middle
                    else:
                        last_index=middle-1
                elif(target > nums[middle]):
                    first_index=middle+1
                else:
                    last_index=middle-1
            return -1
                    
        def last_occurence(nums,target,first_index,last_index):
                if first_index > last_index: 
                    return -1
                while(first_index<=last_index):
                    middle=(first_index+last_index)//2
                    if(target==nums[middle]):
                        if(middle==last_index or target<nums[middle+1]):
                            return middle
                        else:
                            first_index=middle+1
                    elif(target > nums[middle]):
                        first_index=middle+1
                    else:
                        last_index=middle-1
                return -1
        first_index=0
        last_index=len(nums)-1
        first_o=first_occurence(nums,target,first_index,last_index)
        last_o=last_occurence(nums,target,first_index,last_index)   
        return [first_o,last_o]
                    

            