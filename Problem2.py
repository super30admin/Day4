"""
    Leetcode #153 : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    Find Minimum in Rotated Sorted Array
    """


from typing import List


class Solution:
    def __init__(self):
        self.nums = []

    """
    Brute Force Approach:
    Iterate through the array while maintaining a variable to store the minimum value encountered. 
    Finally, return the minimum value. 
    Time Complexity: O(N) - Iterating through the entire array.
    Space Complexity: O(1) - Constant space usage since no additional data structures are used.
    """

    def bruteForceFindMin(self) -> int:
        # Initialize to positive infinity (largest possible number)
        min_value = float('inf')
        for num in self.nums:
            min_value = min(min_value, num)
        return min_value

    """
    Optimized Approach:
    To reduce the time complexity, 
    implement binary search to find the minimum element in the array.
    The key observation is that since the array is rotated, we can determine which side is rotated 
    and decide the search direction accordingly.

    - If `mid` is greater than `high`, 
        the right half is the rotated portion, and the minimum is likely on the right. 
      In this case, update the low pointer: `low = mid + 1`, as `mid` itself cannot be the minimum.
    - If `mid` is less than or equal to `high`, 
        the minimum might lie in the left half or at `mid`. 
      Update the search range to include `mid`: `high = mid`.

    By eliminating half of the search space in each step, 
    the time complexity is reduced to O(log N).
    Time Complexity: O(logN)
    Space Complexity: O(logN) because I've used recursion
    """

    def binarySearch(self, low: int, high: int) -> int:
        # Stopping condition for binary search
        if low >= high:
            return low

        mid = low + (high - low) // 2

        # Compare the middle element with the high element to decide the search direction
        if self.nums[mid] > self.nums[high]:
            # Minimum is in the right half
            return self.binarySearch(mid + 1, high)
        else:
            # Minimum is in the left half (including mid itself)
            return self.binarySearch(low, mid)

    def findMin(self, nums: List[int]) -> int:
        self.nums = nums

        # Handle edge case: empty array
        if not nums:
            return -1

        low = 0
        high = len(nums) - 1

        # Use binary search to find the minimum element
        return nums[self.binarySearch(low, high)]
