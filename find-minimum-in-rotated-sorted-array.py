# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        low = 0
        high = len(nums) - 1

        while low <= high:
            print(low, high)
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2

            if (mid - 1 < low or nums[mid - 1] > nums[mid]) and (mid + 1 > high or nums[mid] < nums[mid + 1]):
                return nums[mid]

            if nums[low] <= nums[mid]:
                low = mid + 1

            else:
                high = mid - 1
