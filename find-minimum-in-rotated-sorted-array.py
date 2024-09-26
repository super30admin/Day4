#Time Complexity: O(N)
#Space Complexity: O(1)
#Did this code successfully run on Leetcode: Yes


class Solution(object):
    def findMin(self, nums):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[low] < nums[high]:
                return nums[low]

            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1