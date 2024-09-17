# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = int(low + (high - low) / 2)

            # checking if mid is the peak element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid

            if (mid == len(nums) - 1 or nums[mid + 1] > nums[mid]):
                low = mid + 1
            else:
                high = mid - 1


