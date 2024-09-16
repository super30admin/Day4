# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def searchRange(self, nums, target):
        if len(nums) == 0:
            return [-1, -1]
        low = 0
        high = len(nums)-1
        #Perform binary search twice to find the leftmost and rightmost indices
        while low < high:
            middle = (low+high)//2
            center = nums[middle]
            if center >= target:
                high = middle
            else:
                low = middle+1
        if nums[low] != target:
            return [-1, -1]
        left = low
        low = 0
        high = len(nums)-1
        while low < high:
            middle = (low+high+1)//2
            center = nums[middle]
            if center <= target:
                low = middle
            else:
                high = middle-1
        return [left, low]