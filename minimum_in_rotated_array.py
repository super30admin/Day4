# Time Complexity: O(logn)
# Space Complexity: O(1)
# Ran on Leetcode: Yes
# Difficulties: Understanding the conditions to return element

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        h = n - 1
        while (l <= h):
            mid = l + (h - l) // 2
            if nums[l] < nums[h]:
                return nums[l]
            if (mid == l or nums[mid] < nums[mid - 1]) and (mid == h or nums[mid] < nums[mid + 1]):
                return nums[mid]

            elif nums[mid] > nums[h]:
                l = mid + 1
            else:
                h = mid - 1
        return -1