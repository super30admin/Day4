'''
LOGIC - Two binary searches are needed one on the either side of the direction to find the target.
Also, have to take care of the base and edge case conditions.
Time Complexity: O(log N), where N indicates the length of the list nums
Space Complexity: O(log 1)
Successfully executed all the testcases and accepted in leetcode
'''

class Solution:
    def binary_search_first(self, nums, target):
        l,r = 0,len(nums)-1
        while l <= r:
            m = l + (r-l)//2
            if nums[m] == target:
                if m == 0 or nums[m] > nums[m-1]:
                    return m
                else:
                    r = m - 1
            else:
                if nums[m] < target:
                    l = m + 1
                else:
                    r = m - 1
        return -1
    
    def binary_search_last(self, first, nums, target):
        l,r = first,len(nums)-1
        while l <= r:
            m = l + (r-l)//2
            if nums[m] == target:
                if m == len(nums)-1 or nums[m] < nums[m+1]:
                    return m
                else:
                    l = m + 1
            else:
                if nums[m] < target:
                    l = m + 1
                else:
                    r = m - 1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == [] or len(nums) == 0:
            return [-1,-1]
        first = self.binary_search_first(nums, target)
        if first == -1:
            return [-1,-1]
        last = self.binary_search_last(first, nums, target)
        return [first, last]
        