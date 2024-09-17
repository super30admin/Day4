"""
Author: Srinidhi Bhat
Did it run on Leetcode: Yes
Time Complexity: O(n) - I came up with a two pointer approach for this questio
Space Complexity: O(1) - Only extra variables


Base Logic: Have two pointer - left and right 
and shift these pointers towards the peak, how?
which ever is smaller mmove than - if right is smaller than left, move it 
towards left 
if left is less than right, move it towards right, that is towards the greater element
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        
        left,right = 0,len(nums)-1
        #till the point to the same element, they need not cross each other
        while left<=right:
            #
            if nums[right] <=nums[left]:
                right = right -1
                
            else:
                left+=1
        return left