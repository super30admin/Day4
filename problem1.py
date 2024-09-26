# Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution(object):
    def searchRange(self, nums, target):
        if not nums:
            return [-1, -1]
        nums1 = self.getFirstPosition(nums, target)
        nums2 = self.getLastPosition(nums, target)
        return [nums1, nums2]

    def getFirstPosition(self, nums, target):
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] >= target:
                right = mid
            else:
                left = mid + 1
        if nums[left] == target:
            return left
        else:
            return -1

    def getLastPosition(self, nums, target):
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2 + 1
            if nums[mid] > target:
                right = mid - 1
            else:
                left = mid
        if nums[left] == target:
            return left
        else:
            return -1

solution = Solution()
sol = solution.searchRange([5,7,7,8,8,10], 8)
print(sol)