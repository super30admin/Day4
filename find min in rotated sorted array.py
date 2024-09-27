# // Time Complexity : O(log n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        # if list has one element
        if len(nums) == 1:
            return nums[0]
        
        s, e = 0, len(nums)-1
        
        # if it is not a rotated list
        if nums[s] < nums[e]:
            return nums[s]
        
        # binary Search
        while (s<=e):
            m = s + (e-s)-1
            
            # if mid is less than previous and next 
            if (nums[m] < nums[m-1]):
                return nums[m]
            
            # if mid is greater than next and less than previous
            if(nums[m] > nums[m+1]):
                return nums[m+1]
            
            # if mid is greater that start min should be on the right of mid  
            if(nums[m] > nums[s]):
                s = m + 1
                
            # if mid is less than start min should be on the left of mid
            if(nums[m] < nums[s]):
                e = m - 1