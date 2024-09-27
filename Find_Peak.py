class Solution(object):
    '''
    Solution:
    1. Need to apply Binary Search to acheive in log time. For this when mid element is calculated, if that element is
        greater than its immediate neighbors, return that index. Otherwise
    2. If the mid element is lesser than its left element, then peak occurs in the left part because-
        - the left element can be 0th index in which case 0th index would be peak
        - if the left element is lesser than left's left element, somewhere in the left chunk we get peak by the same logic.
    3. Similarly, if mid element is lesser than its right element, then peak occurs somewhere in the right part with the
        same logic.

    --- Solution passed all test cases on Leetcode.

    '''
    def findPeakElement(self, nums):
        """
        O(logn) Time Complexity
        O(1) Space Complexity
        """
        low = 0
        high = len(nums) - 1

        while (low < high):
            mid = low + int((high - low) / 2)
            if ((mid == 0) or (nums[mid] > nums[mid - 1])) and ((mid == len(nums) - 1) or (nums[mid] > nums[mid + 1])):
                return mid
            elif (mid > 0) and (nums[mid] < nums[mid - 1]):
                high = mid - 1
            elif (mid < len(nums) - 1) and (nums[mid] < nums[mid + 1]):
                low = mid + 1
            else:
                break

        return low