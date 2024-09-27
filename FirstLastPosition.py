#34. Find First and Last Position of Element in Sorted Array
"""
Time Complexity : O(log n)
Space Complexity : O(1)
Problem run in leetcode : Yes
Any Problem faced : No

Use Binary Search 2 times.
First time to find lower index of target anf second time to get higher index of target.
"""

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, r = 0, len(nums) - 1
        left_most, right_most = -1, -1

        #find left most position
        while l <= r:
            m = (l + r) // 2
            if (nums[m] == target and (m == 0 or nums[m - 1] < target)):
                left_most = m
                break
            if nums[m] >= target:
                r = m - 1
            else:
                l = m + 1

        # find right most position
        l, r = 0, len(nums) - 1
        while l <= r:
            m = (l + r) // 2
            if (nums[m] == target and (m == (len(nums) - 1) or target < nums[m + 1])):
                right_most = m
                break
            if nums[m] <= target:
                l = m + 1
            else:
                r = m - 1

        return [left_most, right_most]