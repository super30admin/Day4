# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):

    def searchfirst(self, nums, target, low, high):
        while low <= high:
            mid = low + (high-low)//2
            # check if mid val is target and if mid-1 is not target
            if nums[mid] == target:
                if mid == low or nums[mid-1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchlast(self, nums, target, low, high):
        while low <= high:
            mid = low + (high-low)//2
            # check if mid val is target and if mid-1 is not target
            if nums[mid] == target:
                if mid == high or nums[mid+1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def searchRange(self, nums, target):
        low = 0
        high = len(nums) - 1
        # edge case if the array is null or only 1 element
        if len(nums) == 0:
            return [-1,-1]
        elif len(nums) == 1 and nums[0] == target:
            return [0, 0]
        # 2 diff methods to find first and last occurrence, at the end return both indices
        first_idx = self.searchfirst(nums, target, low, high)
        last_idx = self.searchlast(nums, target, low, high)
        return [first_idx, last_idx]
