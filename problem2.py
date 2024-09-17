# Time Complexity : O(Log(n))
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1

        if nums[low] <= nums[high]:
            return nums[low]

        while low <= high:
            mid = int(low + (high - low) / 2)

            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1