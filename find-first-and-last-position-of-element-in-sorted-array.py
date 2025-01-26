# Time Complexity : O(2logn)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

"""
I am using binary search twice
First time to find the start position
Second time to find the end position
"""

def getStart(nums, target, low, high):
    while (low <= high):
        mid = low + (high-low)//2
        if nums[mid] == target:
            if mid == 0 or nums[mid - 1] < nums[mid]:
                return mid
            else:
                high = mid - 1
        elif nums[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def getEnd(nums, target, low, high):
    while low <= high:
        mid = low + (high-low)//2
        if nums[mid] == target:
            if mid == high or nums[mid+1] > nums[mid]:
                return mid
            else:
                low = mid + 1
        else:
            high = mid - 1
    return -1


def searchRange(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    n = len(nums)
    if len(nums) != 0 and (target < nums[0] or target > nums[n-1]):
        return [-1,-1]
    else:
        # find start position by using binary search
        start_position = getStart(nums, target, 0,n-1)
        # if target is present in the array
        if start_position != -1:
            # find end position by using binary search. Optimizing by passing low = start_position
            end_position = getEnd(nums, target, start_position, n-1)
            return [start_position, end_position]
        # target not present in the array
        else:
            return [-1,-1]




