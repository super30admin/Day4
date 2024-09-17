'''
Applied Binary Search two times, first to find the index of the left most position
of the target and then to find its right most index.
Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes. I initialized high low variables as
l and h.  Where as used low and high in the code.
'''

class Solution(object):

    def findLeftIndex(self, nums, target):

        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == low or nums[mid] > nums[mid - 1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def findRightIndex(self, nums, target):

        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == high or nums[mid] < nums[mid + 1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if nums == None or len(nums) == 0:
            return [-1, -1]
        leftIndex = self.findLeftIndex(nums, target)
        rightIndex = self.findRightIndex(nums, target)

        return [leftIndex, rightIndex]




