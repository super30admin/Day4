"""
Binary-Search-2
Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1: Input: [3,4,5,1,2] Output: 1

Example 2: Input: [4,5,6,7,0,1,2] Output: 0

Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
To find minimum we're going to perform binary search but we while doing binary search we need to check if array is already sorted by check nums[low] <= nums[high] if yes we can return the nums[low] else
we have to calculate mid and check if mid element is < mid + 1 and < mid - 1 and mid > low and mid < high, if yes then we can return mid else we have to check if left array is sorted by checking mid against low
if arr[mid] >= arr[low] then we move to right side else we move to left side. Trick is we'll always find the minimum in the unsorted part or an edge case can be where left is not sorted but right is sorted then the answer lies in right sorted array.
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2

            if mid > low and nums[mid] < nums[mid - 1] and mid < high and nums[mid] < nums[mid + 1]:
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        return -1 
        
           
