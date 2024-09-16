'''
153. Find Minimum in Rotated Sorted Array
TIME COMPLEXITY:    O(logn) this is a binary search
SPACE COMPLEXITY: O(1)
LEETCODE: Yes, passed all test cases
DIFFICULTIES: Nope
'''

# The idea is to search in unsorted part of the array.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        h = n-1
        
        if nums[l] <= nums[h]:
            return nums[l]
        
        while l<=h:
            m = (l+h)//2
            if l == m and nums[l] > nums[h]:
                return nums[h]
            # aim is to be in unsorted side
            if nums[l] <= nums[m]:
                l = m
            else:
                h = m
