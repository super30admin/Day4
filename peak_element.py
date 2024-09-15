# Time Complexity: O(logn)
# Space Complexity: O(1)
# Ran on Leetcode: Yes
# Difficulties: Understanding the conditions to return element
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        l = 0
        h = len(nums) - 1
        while l <= h:
            mid = l + (h - l) // 2
            if (mid == l or nums[mid] > nums[mid - 1]) and (mid == h or nums[mid] > nums[mid + 1]):
                return mid
            elif mid > l and nums[mid] < nums[mid - 1]:
                h = mid - 1
            else:
                l = mid + 1
                