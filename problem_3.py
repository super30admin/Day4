"""
Problem 3: Find Peak Element
Time Complexity: O(log n)
Space Complexity: O(1)
The code uses a binary search approach to find a peak element in the given list.
It repeatedly divides the search interval in half by comparing the middle element with its neighbors to determine if it is a peak.
If the middle element is not a peak, the search continues in the half where a higher neighbour is present.
The search interval is reduced to half in each iteration, leading to a time complexity of O(log n).
"""

from typing import List


def findPeakElement(nums: List[int]) -> int:
    if not nums or len(nums) == 0:
        return -1

    low = 0
    n = len(nums)
    high = n - 1

    while low <= high:
        mid = low + (high - low) // 2
        if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
            return mid
        elif nums[mid + 1] > nums[mid]:
            low = mid + 1
        else:
            high = mid - 1
    return 456778


findPeakElement([1,2,3,1]) # Expected output: 2
