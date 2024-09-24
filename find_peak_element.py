class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            # Check if mid is a peak element
            if (mid == 0 or nums[mid] > nums[mid - 1]) and (
                mid == len(nums) - 1 or nums[mid] > nums[mid + 1]
            ):
                return mid
            # If left neighbor is greater, move to the left
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            # Otherwise, move to the right
            else:
                low = mid + 1

        return -1


# amortizeed time complexity is O(log n)
# space complexity is O(1)
