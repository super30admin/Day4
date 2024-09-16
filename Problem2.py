'''
Time Complexity: O(log(n))
Space Complexity: O(1)
Run on Leetcode: YES
Problems: Handling base cases
'''
class Solution:
    def findMin(self, nums: list[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low)//2
            if (mid == 0 or nums[mid - 1] > nums[mid]) and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
                