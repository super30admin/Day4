#LC 162 : Find Peak Element
#Time complexity - O(logn)
#Space Complexity : O(1)
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        low = 0
        high = len(nums) - 1
        while low<=high:
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid+1] > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        