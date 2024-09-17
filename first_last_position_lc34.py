"""
Author: Srinidhi
Did the problem run on leetcode: No - I got TLE as I used brute force

Time Complexity: 
Space Complexity:

Logic: Find the first and last position using linear scan and mark the first and last positions in the result array
"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        if len(nums)==1:
            if nums[0] == target:
                return [0,0]
            return [-1,-1]
        
        res = []
        for i in range(len(nums)):
            if nums[i] == target and res == []:
                res.append(i)
            
            elif nums[i] == target and nums[i+1]!=target:
                res.append(i)
            
            elif target not in nums:
                res = [-1,-1]
        return res
