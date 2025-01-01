"""
Problem 2: Find Minimum in Rotated Sorted Array
Time Complexity: O(log n)
Space Complexity: O(1)
The code uses a binary search approach to find the minimum element in the given rotated sorted array.
It compares the element at the mid index with the element at the high index to determine if the array is rotated.
If the array is not rotated, the code returns the element at the low index as the minimum element.
If the array is rotated, the code checks if the mid index is the minimum element by comparing it with its neighbors.
If the mid index is the minimum element, the code returns the element at the mid index.
Otherwise, it updates the low or high index based on the comparison with the element at the mid index.
"""
from typing import List


def findMin(nums: List[int]) -> int:
    if len(nums) == 1:
        return nums[0]
    l = 0
    h = len(nums) - 1
    while l <= h:
        if nums[l] < nums[h]:
            return nums[l]
        mid = l + (h - l) // 2
        if (mid == l or nums[mid - 1] > nums[mid]) and (mid == h or nums[mid + 1] > nums[mid]):
            return nums[mid]
        if nums[l] <= nums[mid]:
            l = mid + 1
        else:
            h = mid - 1

    return 23456


findMin([3,4,5,1,2]) # Expected output: 1
