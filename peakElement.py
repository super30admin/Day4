'''
-- Passed test cases on LeetCode
'''

#Iterative Binary Search Approach
class Solution:
    #O(log n)-- Time Complexity ; O(1) -- Space Complexity
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low < high:
            mid = (low + high) //2
            if (nums[mid] > nums[mid + 1]):
                high = mid
            else:
                low = mid + 1
                
        return low 



            

        
        
