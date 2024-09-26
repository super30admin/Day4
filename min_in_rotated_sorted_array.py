"""
Problem: Find Minimum in Rotated Sorted Array
Leetcode: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Solution: Use Binary search with the fact that if mid num is less than right num, min num is on the left
Time Complexity: O(log n) as we're using binary search
Space Complexity: O(1)
"""


class Solution:
    def findMin(self, nums):
        # Base case - empty array
        if nums is None or len(nums) is 0:
            return -1

        left = 0
        right = len(nums) - 1

        # Binary search
        while left < right:
            mid = int(left + (right - left) / 2)
            if nums[mid] < nums[right]:
                # right = mid instead of (mid - 1) because mid itself can be minimum number
                right = mid
            else:
                left = mid + 1
        return nums[left]


obj = Solution()
# Test Cases:
print(obj.findMin([4,5,6,7,0,1,2]))
# print(obj.findMin([1,2,3,4,5,6]))
# print(obj.findMin([6,5,4,3,2,1]))
# print(obj.findMin([7,1,2,3,4,5,6]))
# print(obj.findMin([5,6,7,1,2,3,4]))
# print(obj.findMin([]))