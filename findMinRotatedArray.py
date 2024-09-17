"""Binary search approach"""
#Accepted on leetcode
#Time complexity - O(logN)
#Space omplexity - O(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """        
        low = 0
        high = len(nums)-1
        while low <= high:
            if nums[low] < nums[high]:
                return nums[low]
            mid = low + (high - low) // 2
            if (low == mid or nums[mid-1] > nums[mid]) and (mid == high or nums[mid] < nums[mid+1]):
                return nums[mid]
            if nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1