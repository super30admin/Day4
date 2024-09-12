# Leetcode 34. Find First and Last Position of Element in Sorted Array

# Time Complexity :  O(log n) for finding the range + O(log n) for implementing binary search
#   where n is the index of the target

# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use two seperate binary search functions and return their output.
# Once the target is found the first binary search keeps moving left until the first occurence is found.
# If the target is found we need to check the next element is different, so we keep moving in that direction
# even if the target is already found.

# Your code here along with comments explaining your approach

class Solution:

    def firstBinarySearch(self, nums, target, low, high):
        while low <= high:
            mid = low + ((high-low)//2)
            if nums[mid] == target:
                # if mid is at zero or the precedding element is != target then mid is the first occurence
                if mid == 0 or nums[mid-1] != target:
                    return mid
            # If the target is less than mid move to the left
            if nums[mid] >= target:
                high = mid - 1

            else:
                low = mid+1

        return -1

    def secondBinarySearch(self, nums, target, low, high):
        while low <= high:
            mid = low + ((high-low)//2)
            if nums[mid] == target:
                # if mid is at last index or the succeding element is != target then mid is the first occurence
                if mid == len(nums)-1 or nums[mid+1] != target:
                    return mid
            # If the target is greater than mid move to the right
            if nums[mid] <= target:
                low = mid + 1

            else:
                high = mid-1

        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums)-1
        first = self.firstBinarySearch(nums, target, low, high)
        second = self.secondBinarySearch(nums, target, low, high)
        return [first, second]
