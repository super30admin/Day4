class Solution(object):
    def findMin(self, nums):
        """
        Solution:
        1. One chunk will definitely be unsorted, go to that chunk
        2. Do this until you have exactly 1 or 2 elements remaining
        3. Return the minimum of those remaining elements

        -- Passed all test cases on Leetcode.
        """

        # O(logn) Time Complexity | O(1) Space Complexity
        low = 0
        high = len(nums) - 1

        while (low <= high):
            mid = low + int((high - low) / 2)
            if (nums[mid] < nums[high]):
                if (low == mid):
                    return nums[mid]
                high = mid
            elif (nums[mid] > nums[low]):
                if (high == mid):
                    return nums[mid]
                low = mid
            else:
                return min(nums[low], nums[high])
