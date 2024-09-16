# Time Complexity = O( log n)
#  Space Complexity = O( 1 )
class Solution(object):
    def findPeakElement(self, nums):

        low = 0
        high = len(nums) - 1

        while low < high:
            mid = low + (high - low) / 2

            if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid + 1] < nums[mid]):
                return mid

            if nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
        if low == high:
            return low
