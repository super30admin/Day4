class Solution(object):
    """"
    The time complexity is of binary search O(logn)
    Space complexity is O(1)
    """
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) / 2
            if (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]) and (
                    nums[mid] > nums[mid - 1] or mid == 0):
                return mid
            elif (mid != 0 and nums[mid] < nums[mid - 1]):
                high = mid - 1
            else:
                low = mid + 1
