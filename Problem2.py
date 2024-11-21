class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if len(nums) == 1:
            return nums[0]

        left = 0
        right = len(nums) - 1

        if nums[right] > nums[left]:
            return nums[left]

        while right >= left:
            mid = left + (right - left) // 2

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            if nums[mid - 1] > nums[mid]:
                return nums[mid]
            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid - 1