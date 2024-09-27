"""
Time complexity: O(logN)
Space complexity: O(1)
Did you  execute in leetcode = Yes. Accepted upon submission
Challenges: To code for different test cases.
Comments: If middle is equal to target, I used while loop to determine the leftmost index and rightmost index. 
Else, the boundaries are shifted.
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums)-1
        
        if not nums:
            return [-1,-1]
        
        while left <= right:
            middle = left + (right-left)//2
  
            if nums[middle]==target:
                leftidx,rightidx = middle,middle
                
                while leftidx>0 and nums[leftidx]==nums[leftidx-1]:
                    leftidx = leftidx-1
                    
                while rightidx<len(nums)-1 and nums[rightidx]==nums[rightidx+1]:
                    rightidx = rightidx+1
                    
                return [leftidx,rightidx]
            
            elif nums[middle] < target:
                left = middle + 1
            
            elif nums[middle] > target:
                right = middle - 1
                
        return [-1,-1]
