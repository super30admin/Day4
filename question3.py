#Time-Complexity: O(logn)
#Space-Complexity: O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        N = len(nums)
        l , r = 1 , len(nums)-2 # Not searching the first & the last elements

        if N == 1: return 0 
        if N > 1 and nums[0] > nums[1]: 
            return 0 
        if N > 1 and nums[-1] > nums[-2]: 
            return N-1 

        while l <= r:
            m = (l+r) // 2
            
            if nums[m] >= nums[m-1] and nums[m] >= nums[m+1]: return m
            elif nums[m-1] >= nums[m]: r = m-1
            else: l = m+1
                    
        return -1