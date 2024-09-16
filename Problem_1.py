class Solution(object):
    """"
    The time complexity is of binary search O(logn)
    Space complexity is O(1)
"""
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) == 0:
            return [-1, -1]
        if target < nums[0] or target > nums[len(nums) - 1]:
            return [-1, -1]

        first = self.binarySearchFirst(nums, target)
        if first == -1:
            return [-1, -1]
        second = self.binarySearchSecond(nums, target)
        if second == -1:
            return [first, first]
        else:
            return [first, second]

    def binarySearchFirst(self, nums, target):
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + (high - low) / 2
            if (target == nums[mid]):
                if (mid == 0 or nums[mid - 1] < nums[mid]):
                    return mid
                else:
                    high = mid - 1
            elif (target < nums[mid]):
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def binarySearchSecond(self, nums, target):
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + (high - low) / 2
            if (target == nums[mid]):
                if (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                    return mid
                else:
                    low = mid + 1
            elif (target < nums[mid]):
                high = mid - 1
            else:
                low = mid + 1
        return -1
