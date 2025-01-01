"""
Problem 1: Find First and Last Position of Element in Sorted Array
Time Complexity: O(log n)
Space Complexity: O(1)
The code uses a binary search approach to find the first and last position of the target element in the given list.
It first finds the first occurrence of the target element by performing a binary search and checking if the element at the mid index is the target element.
If the mid index is the first occurrence of the target element, or if the element before the mid index is not the target element, the code returns the mid index.
Otherwise, it updates the high index to mid - 1 and continues the binary search.
Similarly, the code finds the last occurrence of the target element by performing a binary search and checking if the element at the mid index is the target element.
If the mid index is the last occurrence of the target element, or if the element after the mid index is not the target element, the code returns the mid index.
Otherwise, it updates the low index to mid + 1 and continues the binary search.
"""

from typing import List


def searchRange(nums: List[int], target: int) -> List[int]:

    def binarysearchFirst():
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != nums[mid]:
                    return mid
                else:
                    r = mid - 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return -1

    def binarysearchLast():
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] != nums[mid]:
                    return mid
                else:
                    l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        return -1

    first = binarysearchFirst()
    if first == -1:
        return [-1, -1]
    second = binarysearchLast()
    return [first, second]


searchRange([5,7,7,8,8,10], 8) # Expected output: [3, 4]