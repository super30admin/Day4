'''
Time Complexity: O(log(n))
Space Complexity: O(1)
Run on Leetcode: YES
Problems: Handling eleminating conditions
'''
class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low)//2
            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid + 1] < nums[mid]):
                return mid
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1