"""
Python3 
Time complexity : O(Log(N))
Space Complexity : O(1)
Leetcode submitted successfully : YES


"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        if (not nums) or len(nums) == 0:
            return -1
        
        left = 0
        right = len(nums)-1
        
        while left <= right:
            mid = int(left + (right-left)/2)
            if (mid == 0  or  nums[mid] > nums[mid-1])  and (mid == len(nums)- 1 or nums[mid] > nums[mid+1]) :
                return mid
            elif mid > 0  and nums[mid-1] > nums[mid] :
                right = mid-1
            else:
                left = mid + 1
    
                
        return -1