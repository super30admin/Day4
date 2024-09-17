# ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

# Find the minimum element.

# You may assume no duplicate exists in the array.

# Example 1:
# Input: [3,4,5,1,2]
# Output: 1

# Example 2:
# Input: [4,5,6,7,0,1,2]
# Output: 0

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if nums[0] < nums[-1]:
            return nums[0]
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            elif nums[mid] > nums[l]:
                l = mid
            else:
                r = mid
                
# Time Complexity -> log(n)
# Space Complexity -> o(1)