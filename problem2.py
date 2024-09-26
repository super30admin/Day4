# Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution(object):
    def findMin(self, nums):
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] < nums[0]:
                right = mid
            else:
                left = mid + 1
        if nums[left] < nums[0]:
            return nums[left]
        else:
            return nums[0]

solution = Solution()
sol = solution.findMin([3,4,5,1,2])
print(sol)