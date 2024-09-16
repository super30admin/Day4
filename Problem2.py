# Time Complexity : O(log n)
# Space Complexity :O(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        # if the arry is already sorted
        if nums[0] < nums[len(nums) - 1]:
            return nums[0]
        # if array just has one elemenr
        if len(nums) == 1:
            return nums[0]

        l = 0
        h = len(nums) - 1

        while (l <= h):
            mid = (l + h) // 2
            # if the mid element is greater than its next element then return next element
            if mid + 1 < len(nums) and nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            # if themid element is less than the previous element then return the mid element
            if mid - 1 >= 0 and nums[mid] < nums[mid - 1]:
                return nums[mid]
            if nums[mid] > nums[0]:
                l = mid + 1
            else:
                h = mid - 1

