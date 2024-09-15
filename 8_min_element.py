# S30 Big N Problem #8 {Medium}

# Given a sorted array rotated at some pivot.
# (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
# Find the minimum element in the arraygiven that there are no duplicate elements in the array.

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        
        low,high=0,len(nums)-1
        
        while low<=high:
            
            mid=low+(high-low)//2
            
            # if previous element to mid is greater than mid is the least element
            if mid!=0 and nums[mid]<nums[mid-1]:
                return nums[mid]
            # if right side is sorted, least element on the left side
            elif nums[mid]<=nums[high]:
                high=mid-1
            # if left side is sorted, least element on the right side
            else:
                low=mid+1
        
        low,high=0,len(nums)-1

        # if 1st element is least
        if nums[low]<=nums[high]:
            return nums[low]
        # if last element is least
        else:
            return nums[high]
        