# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        if len(nums) == 1:
            return 0

        while low <= high:
            mid = low + (high - low) // 2
            print(mid)

            if (mid - 1 < low or nums[mid - 1] < nums[mid]) and (mid + 1 > high or nums[mid + 1] < nums[mid]):
                return mid

            elif mid + 1 <= high and nums[mid + 1] > nums[mid]:
                low = mid + 1

            else:
                high = mid - 1
