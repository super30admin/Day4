# Python3

class Solution:
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # approach: compare mid with the leftest element and decide direction

        left = 0
        right = len(nums) - 1

        while left + 1 < right:
            if nums[left] < nums[right]:
                return nums[left]

            mid = left + (right - left) // 2

            # preserve mid for next comparison so it remains unordered
            if nums[left] < nums[mid]:
                left = mid
            else:
                right = mid

        return nums[left] if nums[left] < nums[right] else nums[right]