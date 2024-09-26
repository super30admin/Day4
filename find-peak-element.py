#Time Complexity: O(N)
#Space Complexity: O(1)
#Did this code successfully run on Leetcode: Yes


class Solution(object):
    def findPeakElement(self, nums):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if (mid == high or nums[mid] > nums[mid + 1]) and (mid == low or nums[mid] > nums[mid - 1]):
                return mid
            elif mid == high or nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
