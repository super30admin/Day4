# Find Peak Element
'''
Leetcode all test cases passed: Yes
Solution:
    findPeakElement(self, nums, target):
        Space Complexity: O(1)
        Time Complexity: O(log n)
    
'''


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l <= r:
            mid = l + ((r - l) // 2)
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid

            elif mid + 1 < len(nums) and nums[mid] < nums[mid + 1]:
                l = mid + 1
            else:
                r = mid
