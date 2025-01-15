"""
    Leetcode #34: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Find First and Last Position of Element in Sorted Array
"""


from typing import List


class Solution:
    def __init__(self):
        self.nums = []
        self.target = 0
        """
        Brute Force Solution: In this approach, in a linear fashion 
        I can find the first occurance of target, by simply searching 
        the target either present at 0th index or nums[index -1] != target
        same way find the last occurance either present at last index 
        or index+ 1 element is not equal to target
        Time Complexity: O(N)
        Space compexity: Constant O(1)
        """

    def linearSearchFirst(self) -> int:
        for i, num in enumerate(self.nums):
            if num == self.target and (i == 0 or self.nums[i-1] != self.target):
                return i
        # outside for loop, cant find target
        return -1

    def lastOccurance(self) -> int:
        for i, num in enumerate(self.nums):
            if num == self.target and (i == len(self.nums) - 1 or self.nums[i+1] != self.target):
                return i
        # outside for loop, cant find target
        return -1

    def searchRangeBruteForce(self, nums: List[int], target: int) -> List[int]:
        self.nums = nums
        self.target = target

        # base case
        if not nums:
            return [-1, -1]

        first_occurance = self.linearSearchFirst()
        last_occurance = self.lastOccurance()
        return [first_occurance, last_occurance]

    """
    Optimize approach: we can find the first occurance 
    and last occurance using binary search itself.
    conditions for binary search:
    for first occurance: 
        - element is target and index is zero
        - elemnt is target and index - 1 elemnt is not equal to target
    for last occurance:
        - element is target and index is length of list minus one len(nums) - 1
        - elemnt is target and index + 1 is not equal to target
    Time complexity: both binary search requires O(logN)
    Space Complexity: Constant O(1)
    """

    def binarySearchFirstOccurance(self, low: int, high: int) -> int:

        # stopping condition
        if low > high:
            return -1

        # calculate mid
        mid = low + (high - low) // 2

        if self.nums[mid] == self.target and (mid == 0 or self.nums[mid] != self.nums[mid - 1]):
            return mid
        else:
            # we are not at the taget
            if self.nums[mid] < self.target:
                # move right
                low = mid + 1
                return self.binarySearchFirstOccurance(low, high)
            else:
                # move left
                high = mid - 1
                return self.binarySearchFirstOccurance(low, high)

    def binarySearchLastOccurance(self, low: int, high: int) -> int:

        # stopping condition
        if low > high:
            return -1

        # calculate mid
        mid = low + (high - low) // 2
        last_index = len(self.nums) - 1
        if self.nums[mid] == self.target and (mid == last_index or self.nums[mid] != self.nums[mid + 1]):
            return mid
        else:
            # we are not at the target
            if self.nums[mid] <= self.target:
                # move right
                low = mid + 1
                return self.binarySearchLastOccurance(low, high)
            else:
                # move left
                high = mid - 1
                return self.binarySearchLastOccurance(low, high)

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        self.nums = nums
        self.target = target

        # base case
        if not nums:
            return [-1, -1]

        first_occurence = self.binarySearchFirstOccurance(0, len(nums)-1)
        last_occurence = self.binarySearchLastOccurance(0, len(nums)-1)

        return [first_occurence, last_occurence]
