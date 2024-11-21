"""
Time complexity: O(logn) where n is the number of elements
Space complexity: O(1) no extra space is used
Execution: complete
No doubts
"""


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or nums is None:
            return [-1, -1]

        # carrying out separate binary searches for first index and last index
        first_index = self.binarysearchFirst(nums, target)
        last_index = self.binarysearchLast(nums, target)
        return [first_index, last_index]

    def binarysearchFirst(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:  # if the mid is the target
                if mid == 0 or nums[mid] > nums[
                    mid - 1]:  # to check if its the first index, checking if its in the zer0 index or checking if the element previous is smaller to the current element
                    return mid  # return mid
                else:
                    high = mid - 1  # else move the high to the first half, cos we know first index is in the first half
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarysearchLast(self, nums, target):
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[
                    mid + 1]:  # simimlary checking if the last index is in the end of the array or if the element next to is greater than the current element
                    return mid
                else:
                    low = mid + 1  # else move the low to the second halfgitg
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

