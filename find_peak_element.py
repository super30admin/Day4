# Time COmplexity : O(logn)
# Space Complexity : O(1)
# Approach to solve the problem:

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        l, r = 0, len(nums) - 1                       # Initializing left and right
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[mid+1]:
                r = mid 
            else:
                l = mid + 1
        return l