## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
# Time Complexity: O(logn) - because we are using binary search and hence the size of the window reduces by half
# Space Complexity - O(1)
# Explanation - Using binary search we keep comparing the mid with its left and right element first, and then decide the left or right part of the array by comparing the element at low with mid OR element at high


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while(low <= high):
            if(nums[low] <= nums[high]):
                return nums[low]
            mid = low + (high-low)//2
            # checking mid = 0 for keeping it in bounds
            if((nums[mid] <= nums[mid-1]) and (nums[mid] <= nums[mid+1])):
                return nums[mid]
            elif nums[mid] < nums[low]:
                high = mid-1
            elif nums[mid] > nums[high]:
                low = mid+1
        return -1
