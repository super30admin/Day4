# Problem 3: (https://leetcode.com/problems/find-peak-element/)
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution(object):
    def findPeakElement(self, nums):
        left = 0
        right = len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            if (nums[mid] > nums[mid+ 1]):
                right = mid
            else:
                left = mid + 1
        return right

solution = Solution()
sol = solution.findPeakElement([1,2,1,3,5,6,4])
print(sol)