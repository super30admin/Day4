"""
Leecode #162 : https://leetcode.com/problems/find-peak-element/description/
Find Peak Element
    """


from typing import List


class Solution:
    """
    Brute Force Approach: Traverse the array linearly to find the peak element.
    A peak element is one that is greater than its neighbors. Handle edge cases where:
    - The length of the array is 1 (the single element is the peak).

    Time Complexity: O(N) since we are traversing the array once.
    Space Complexity: O(1) since no additional space is used.
    """

    def findPeakElementBruteForce(self, nums: List[int]) -> int:
        # Edge case: Empty array
        if not nums:
            return -1

        # Edge case: Single element
        if len(nums) == 1:
            return 0

        # Traverse the array to find the peak
        for i in range(len(nums)):
            # Case: First element is a peak
            if i == 0 and nums[i] > nums[i + 1]:
                return 0

            # Case: Last element is a peak
            if i == len(nums) - 1 and nums[i] > nums[i - 1]:
                return i

            # Case: Peak in the middle
            if nums[i - 1] < nums[i] > nums[i + 1]:
                return i

        # If no peak found (this should never happen in a valid input)
        return -1

    """
    Optimized Approach: Use binary search to find the peak element.
    Observations:
    - A peak element is greater than its neighbors.
    - If nums[mid] < nums[mid + 1], move to the right (higher possibility of a peak).
    - If nums[mid] > nums[mid + 1], move to the left (higher possibility of a peak).

    Time Complexity: O(log N) due to binary search.
    Space Complexity: O(1) for iterative binary search or O(log N) for recursion stack.
    """

    def binarySearch(self, nums: List[int], low: int, high: int) -> int:
        # Binary search to find the peak element
        while low < high:
            mid = low + (high - low) // 2

            # Move to the side with a higher element
            if nums[mid] < nums[mid + 1]:
                low = mid + 1  # Move right
            else:
                high = mid  # Move left
                # mid is greater than mid + 1 and
                # mid could be peak, so to include mid in serach space we do high = mid )
        return low

    def findPeakElement(self, nums: List[int]) -> int:
        # Edge case: Empty list
        if not nums:
            return -1

        # Single element in the list
        if len(nums) == 1:
            return 0  # Peak is at index 0

        return self.binarySearch(nums, 0, len(nums) - 1)
