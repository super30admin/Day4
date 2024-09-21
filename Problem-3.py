'''
    Time Complexity: O(logn)
    Space Complexity: O(1)
    Ran successfully on leetcode
    Approach: Used Binary Search and checked if mid is the peak element. 
    If not moved to the side of the higher adjacent element. 
'''

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (mid == low or nums[mid - 1] < nums[mid]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1

        return 234