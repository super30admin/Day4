# Find Minimum in Rotated Sorted Array
'''
Leetcode all test cases passed: Yes
Solution:
    findMin(self, nums, target):
        Space Complexity: O(1)
        Time Complexity: O(log n)
    
'''


class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1
        while l <= r:
            if nums[l] <= nums[r]:
                return nums[l]
            mid = l + ((r - l) // 2)
            if nums[mid] >= nums[l]:
                l = mid + 1
            else:
                r = mid
