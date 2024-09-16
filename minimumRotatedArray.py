class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        left, right = 0, len(nums) - 1

        if nums[0] < nums[right]:
            return nums[0]
        while left <= right:

            mid = left + (right - left) / 2
            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]

            if nums[mid] < nums[mid - 1]:
                return nums[mid]

            if nums[left] < nums[mid]:
                left = mid + 1
            else:
                right = mid - 1


                #ln(n)