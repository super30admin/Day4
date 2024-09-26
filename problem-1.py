# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

from typing import List
def searchRange(nums: List[int], target: int) -> List[int]:
    firstOccurence = binarySearch(nums, target, True)
    lastOccurence = binarySearch(nums, target, False)

    return [firstOccurence, lastOccurence]

# if leftBias is true, look for leftmost occurence of target element
def binarySearch(nums: List[int], target: int, leftBias: bool) -> int:
    l, r = 0, len(nums) - 1
    res = -1
    while l<=r:
        m = l + (r-l)//2

        if nums[m] == target:
            res = m
            if leftBias:
                r = m - 1
            else:
                l = m + 1

        elif nums[m] < target:
            l = m + 1
        else:
            r = m - 1
    return res



nums = [5,7,7,8,8,10]
target = 8

print(searchRange(nums, target))





