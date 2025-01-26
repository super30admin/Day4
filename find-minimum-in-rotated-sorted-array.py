# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

"""
In a rotated sorted array, at least one side of the array would be sorted and min would always be on the non-sorted side.
I am using binary search to discard the sorted side of the array as follows:
1. Firstly if nums[mid] == min, then return nums[mid]
2. If left side is sorted, discard left side else discard right side
"""

def findMin(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    n = len(nums)
    low = 0
    high = n - 1

    while low <= high:
        # if array is sorted, return the first element
        if nums[low] <= nums[high]:
            return nums[low]
        mid = low + (high - low) // 2
        # if mid is the min
        if (mid == 0 or nums[mid - 1] > nums[mid]) and (mid == n - 1 or nums[mid + 1] > nums[mid]):
            return nums[mid]
        # left side sorted so discard left side
        elif nums[low] <= nums[mid]:
            low = mid + 1
        # right side is sorted so discard right side
        else:
            high = mid - 1
    return -1

