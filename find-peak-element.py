# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

"""
I am using binary search to pick the side of the array where there is gurantee to have a peak
Firstly if nums[mid] == peak, then return nums[mid]
Peak would be on side where there is upward slope from mid i.e nums[mid+1] > nums[mid]
So pick a side where nums[mid+1] > nums[mid] and discard the other half.
"""


def findPeakElement(nums):
    """
    :type nums: List[int]
    :rtype: int
    """

    n = len(nums)
    low = 0
    high = n - 1

    while low <= high:
        mid = low + (high - low) // 2
        # if mid is peak
        if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == n - 1 or nums[mid] > nums[mid + 1]):
            return mid
        # if left side has an upward slope
        elif nums[mid + 1] > nums[mid]:
            low = mid + 1
        # if right side has an upward slope
        else:
            high = mid - 1

    return -1

