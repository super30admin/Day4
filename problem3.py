# Find Peak element (any)
# Using binary search only because:
    # - No consecutibe duplicates
    # - -infinity is the bound for array start and end
    # - any peak element is accepted
# Time complexity: O(logn)
# Space complexity: O(n)

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low)/2
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and
                (mid == len(nums)-1 or nums[mid] > nums[mid + 1])):
                return mid
            elif nums[mid] < nums[mid + 1]:
                low = mid + 1
            else:
                high = mid - 1
        return -1