"""
Time complexity: O(logN)
Space complexity: O(1)
Did you  execute in leetcode = No, getting time limit exceeded.
Challenges: To code for different test cases.
Comments:In this code, I have checked if middle is  greator than middle -1 and middle+1. If yes, it is returned as the answer.
Else, we check if middle -1 is greator and shift right to middle -1. Similarly, if middle +1 is greator, we shift left to middle+1.
"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        if not nums:
            return -1
        left = 0
        right = len(nums)-1
        
        while left <= right:
            middle = left + (right -left)//2
            
            if middle>0 and nums[middle] > nums[middle-1]:
                if middle<len(nums)-1 and nums[middle] > nums[middle+1]:
                    return nums[middle]
                
            elif middle<len(nums)-1 and nums[middle]<nums[middle+1]:
                right = middle-1
                continue
                
            elif middle>0 and nums[middle]>nums[middle-1]:
                left = middle+1
                continue
                
        return -1
        
