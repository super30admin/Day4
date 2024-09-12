# Time Complexity : O(lg N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nope.. Was able to figure out solution with 
# LogN time after drawing it out.


# Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        """
        want to return a list. populate list with binary search.. 
        Spitballin thoughts:
            - Can linearly scan O(N) when we find the first element of the target (start) until the last element (end)..
            - SHOULD DO THIS IS O(LgN) THO. 
        FIGURED IT OUT:
            - We bSearch until we find the target value.. 
            Once we find the target value we can still bSearch from:
                - left -> mid (look for smallest index)
                - mid -> right(look for highest index)
        """
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2 #do this to prevent overflow
            
            if target == nums[mid]:
                return [self.bSearchForStartIndex(left, mid, nums, target), self.bSearchForEndIndex(mid, right, nums, target)]
            elif target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
                
        return [-1,-1]
    
    
    #binary search from left to mid
    def bSearchForStartIndex(self, left, right, nums, target):
        startVal = right
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if nums[mid] == target:
                startVal = mid 
                right = mid - 1 #want to keep searching left side
            else:
                left = mid + 1
        
        return startVal 
    #binary search from mid to right
    def bSearchForEndIndex(self, left, right, nums, target):
        endVal = left 
        while left <= right:
            mid = left + (right - left) // 2
            
            if nums[mid] == target:
                endVal = mid
                left = mid + 1
            else:
                right = mid - 1
        return endVal
        
        
        
        