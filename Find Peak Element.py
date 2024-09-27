'''
LOGIC - Binary Search Algorithm is used here.
After finding the mid element, considering the base and edge cases conditions, we have to go in the greater directon
If both side values are greater, we can go in either direction.
Time Complexity: O(log N), where N indicates the length of the list nums
Space Complexity: O(1)
Successfully executed all the testcases and accepted in leetcode
'''

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l,r = 0,len(nums)-1
        while l <= r:
            m = l + (r-l)//2
            if (m == 0 or nums[m] > nums[m-1]) and (m == len(nums) - 1 or nums[m] > nums[m+1]):
                return m
            elif nums[m] < nums[m + 1]:
                l = m + 1
            else:
                r = m - 1