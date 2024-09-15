#brute force-O(n)
#space-O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        min_val= float('inf')
        for i in range(0,len(nums)):
            if min_val>nums[i]:
                min_val=nums[i]
        return min_val
        
