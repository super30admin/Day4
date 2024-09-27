# Time Complexity : O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        if target < nums[0] or target > nums[-1]:
            return [-1, -1]
        firstPosition = self.binarySearchLeft(nums, target)
        if firstPosition == -1:
            return [-1, -1]
        lastPosition = self.binarySearchRight(nums, target)
        return [firstPosition, lastPosition]

    def binarySearchLeft(self, nums, target):
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = (l + h) // 2
            if nums[mid] == target:
                if mid == 0 or (nums[mid - 1] < nums[mid]):
                    return mid
                h = mid - 1
            elif target < nums[mid]:
                h = mid - 1
            else:
                l = mid + 1
        return -1

    def binarySearchRight(self, nums, target):
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = (l + h) // 2
            if nums[mid] == target:
                if mid == (len(nums) - 1) or nums[mid + 1] > nums[mid]:
                    return mid
                else:
                    l = mid + 1
            elif nums[mid] < target:
                l = mid + 1
            else:
                h = mid - 1
        return -1

