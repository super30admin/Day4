
# // Time Complexity : O(logN)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

# Find the minimum element.

# You may assume no duplicate exists in the array.

# Example 1: Input: [3,4,5,1,2] Output: 1

# Example 2: Input: [4,5,6,7,0,1,2] Output: 0

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if nums == [] and len(nums) == 0:
            return -1
        
        low =0 
        high = len(nums) -1
        
        while low <= high:
            if nums[low] < nums[high]:
                return  nums[low]
            
            mid = low + (high-low)//2
            
            # if mid is minimum
            if (mid == 0 or (nums[mid -1] > nums[mid]) ) and \
            (mid == len(nums)-1 or nums[mid+1]>nums[mid]):
                    return nums[mid]
            # if left side sorted
            elif(nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid - 1
                
        return 7272
        