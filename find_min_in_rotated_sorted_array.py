from typing import List
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:return nums[0]
        l, r = 0 , len(nums) -1
        while l<=r:
            m = (l+r) >>1
            # we find the target, we return the number
            if nums[m] < nums[m - 1]:
                return nums[m]
            else: # [rotated] m [sorted] or [sorted]m[rotated]
                if nums[m] < nums[r]: # [rotated] m [sorted]
                    r = m - 1
                else:# [sorted]m[rotated]
                    l = m + 1
# if the while loop finished, it means we didn't find the number, so we return -1
        return -1        
                
                
            