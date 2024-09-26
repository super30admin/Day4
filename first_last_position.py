"""
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Time Complexity: O(log n)
Space Complexity: O(1)
"""


def bs(nums, target, bias):
    l, r = 0, len(nums) - 1
    while l <= r:
        mid = (l + r) // 2

        if nums[mid] < target:
            l = mid + 1
        elif nums[mid] > target:
            r = mid - 1

        else:
            i = mid
            if bias:
                r = mid - 1
            else:
                l = mid + 1

    return i


def first_last_position(nums, target):
    left = bs(nums, target, True)
    right = -1 if left == -1 else bs(nums, target, False)
    return [left, right]


print(first_last_position([1, 2, 3, 3, 3, 3, 4, 5, 6], 3))
