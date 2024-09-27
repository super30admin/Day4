# // Time Complexity : logn
# // Space Complexity :
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach
# Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
#
# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
#
# Find the minimum element.
#
# You may assume no duplicate exists in the array.
#
# Example 1: Input: [3,4,5,1,2] Output: 1
#
# Example 2: Input: [4,5,6,7,0,1,2] Output: 0

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            m = int(left + (right - left) / 2)
            if (m == 0 or nums[m - 1] > nums[m]) and (m == len(nums) - 1 or nums[m + 1] > nums[m]):
                return nums[m]
            if nums[m] < nums[right]:
                right = m - 1
            else:
                left = m + 1
