#Leetcode 153 : Find Minimum in Rotated Sorted Array
#Time Complexity : O(logn)
#Space Complexity : O(1)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high)//2
            if low == high or (nums[mid] < nums[mid-1] and nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[mid] < nums[high]:
                high = mid - 1
            else:
                low = mid + 1