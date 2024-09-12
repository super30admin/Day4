# coding=utf-8
"""
162. Find peak element
A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
You must write an algorithm that runs in O(log n) time.

Approach --
1. Find mid.
2. check if mid is the peak by checking if the element is greater than its neighbours then return the index of the
element
2. if mid is not peak, check if the element on the right of mid is greater than mid-element. if yes move right &
do Binary search
3. else move left and do Binary search

Time Complexity- O(log n)
Space complexity - O(1)
"""
# n = [1, 2, 3, 1]
# n = [1,2,1,3,5,6,4]
n = [1, 2, 3, 4]


def findpeakelement(nums):
    if len(nums) == 0 or nums is None:
        return -1
    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = low + (high - low) // 2  # prevent overflow

        # check if on mid
        if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
            return mid

        # go to the right since its in increasing order
        # mid == len-1 is checked if mid is the last element
        if (mid == len(nums) - 1) or nums[mid + 1] > nums[mid]:
            low = mid + 1
        else:
            high = mid - 1
    return -1


print(findpeakelement(n))