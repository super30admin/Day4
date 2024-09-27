# Time Complexity : O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        l = 0
        h = len(nums) - 1

        while l <= h:
            if nums[l] < nums[h]:
                return nums[l]
            mid = (l + h) // 2
            if (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]) and (mid == 0 or nums[mid] < nums[mid - 1]):
                return nums[mid]
            if nums[l] <= nums[mid]:
                l = mid + 1
            else:
                h = mid - 1