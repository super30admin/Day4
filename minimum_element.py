# Time Complexity = O( log n)
#  Space Complexity = O( 1 )
class Solution(object):
    def findMin(self, nums):
        low = 0
        high = len(nums) - 1

        if len(nums) == 1:
            return nums[0]

        if nums[high] > nums[0]:
            return nums[0]

        while low <= high:
            mid = low + (high - low) / 2

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            if nums[mid - 1] > nums[mid]:
                return nums[mid]

            if nums[0] < nums[mid]:
                low = mid + 1
            else:
                high = mid - 1

        """
        :type nums: List[int]
        :rtype: int
        """
