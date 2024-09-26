# One peak element will always be there in the increasing side.
# Leetcode submission successful.
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Binary search as O(log n) time complexity expected.
        # Space complexity: O(1)

        # Left to first element and right to last element is minus infinity.

        if len(nums) == 1:
            return 0
        if nums[0] > nums[1]:
            return 0
        if nums[-1] > nums[-2]:
            return len(nums) - 1

        lo = 0
        hi = len(nums) - 1
        while (lo <= hi):
            mid = lo + (hi - lo) / 2

            # checking if element is greater than its adjacent elements.
            if (nums[mid] > nums[mid - 1] and mid != 0) and (nums[mid] > nums[mid + 1] and mid != (len(nums) - 1)):
                return mid
            else:
                # we will check in the increasing side because there will be a peak element there.
                if (nums[mid] < nums[mid + 1]):
                    lo = mid + 1
                else:
                    hi = mid - 1