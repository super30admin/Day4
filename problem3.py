'''
162. Find Peak Element
TIME COMPLEXITY: O(logN) because it is a binary search
SPACE COMPLEXITY: O(1)
LEETCODE: Yes
DIFFICULTIES: Nope
'''

# Binary search is either to move left part or right part
# direction is decided, based up on where, highest element than middle element lies

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        h = n-1
        
        while l<=h:
            m = (l+h)//2
            if l == m:
                if nums[l] < nums[h]:
                    return h
                else:
                    return l
            if nums[m] < nums[m+1] and m+1 <= h:
                l = m + 1
            else:
                h = m
                
        
