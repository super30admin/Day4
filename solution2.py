# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def find_min(self, nums):
        # edge case 
        if len(nums) == 1:
            return nums[0]

        # left pointer
        left = 0
        # right pointer
        right = len(nums) - 1

        # if already sorted
        if nums[right] > nums[0]:
            return nums[0]

        # Binary search
        while right >= left:
            mid = left + (right - left) // 2
            # base case where this is where values change
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            # base case 2 
            if nums[mid - 1] > nums[mid]:
                return nums[mid]

            # min on right side
            if nums[mid] > nums[0]:
                left = mid + 1
            # min on left side 
            else:
                right = mid - 1