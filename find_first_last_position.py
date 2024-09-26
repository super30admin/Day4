# Time COmplexity: O(nlogn)
# Space Complexity: O(1)
# Is this problem on leetcode: Yes
# Approach to solve this problem is explained below:

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums: return [-1,-1]
        N = len(nums)
        st,end = -1,-1
        l,r = 0,N                                           # Declared left and right
        
                                                            # binary Search Left
        while l<r:
            mid = (l+r)//2
            if nums[mid]>=target:
                r = mid
            else:
                l = mid+1
        if l<N and nums[l] == target:
            st = l
            
                                                            # binary search right
        
        l,r = 0, N
        while l<r:
            mid = (l+r)//2
            if nums[mid]<= target:
                l = mid+1
            else:
                r=mid
        if nums[r-1] == target:
            end = r-1
        
        return [st,end]                                     # Returned the first and last element