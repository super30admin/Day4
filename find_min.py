# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def findMin(self, nums):
        if len(nums) == 0: 
            return -1
        if len(nums) == 1: 
            return nums[0]
        
        left, right = 0, len(nums)-1
        
        while(left < right):
            pivot = (left + right) // 2
            
            if nums[pivot] > nums[right]:
                left = pivot +1
            else: 
                right = pivot
                
        return nums[left]
        