# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, was trying to do using recursion. But couldn't device a perfect base case
# Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # Binary search to get left most index
        def binarySearchLeft(nums, target):
            left, right = 0, len(nums)-1
            while left <= right:
                mid = left + (right - left) // 2
                # Move till you find first target
                if target > nums[mid]:
                    left = mid + 1
                # Movement of right index is not an issue
                else:
                    right = mid - 1
            return left
        
        def binarySearchRight(nums, target):
            left, right = 0, len(nums)-1
            while left <= right:
                mid = left + (right - left) // 2
                # Move left till you cross last target
                if target >= nums[mid]:
                    left = mid + 1
                # Move right once to capture the last target and exit while loop
                else:
                    right = mid - 1
            return right
        
        # Initialise left and right index from two methods
        left, right = binarySearchLeft(nums, target), binarySearchRight(nums, target)
        
        return (left, right) if left <= right else [-1, -1]
