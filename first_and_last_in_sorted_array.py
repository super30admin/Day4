"""
Problem: Find First and Last Position of Element in Sorted Array
Leetcode: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Example:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
Solution: Use binary search to find target on left and right side of mid separately
Time Complexity: O(log n), binary search used twice
Space Complexity: O(1)
"""

class Solution:
    # Base Case, which should be returned if no target is found
    output = [-1,-1]

    # Search first and last position of an element in an array
    def search(self, nums, target):
        # base case - empty array
        if nums is None or len(nums) is 0:
            return self.output
        left = 0
        right = len(nums) - 1
        self.binarySearch(nums, target, left, right, True)
        self.binarySearch(nums, target, left, right, False)
        return self.output

    # Binary search function with flag to traverse either left or right
    def binarySearch(self, nums, target, left, right, isLeft):
        while left <= right:
            mid = int(left + (right - left)/2)
            # Case 1
            if nums[mid] == target:
                if isLeft:
                    self.output[0] = mid
                    right = mid - 1
                else:
                    self.output[1] = mid
                    left = mid + 1
            # Case 2
            elif nums[mid] < target:
                left = mid + 1
            # Case 3
            else:
                right = mid - 1


obj = Solution()
# Test Cases:
print(obj.search([5,7,7,8,8,10], 8))
# print(obj.search([8,8,8,8,8,8], 8))
# print(obj.search([5,7,7,8,8,10], 9))
# print(obj.search([], 9))