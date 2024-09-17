# Time Complexity: O(logn)
# Space Complexity: O(1)
# Any problem you faced while coding this : No
# Did this code successfully run on Leetcode: Yes

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        
        while(low<=high):
            if nums[low]<=nums[high]:
                return nums[low]
            
            mid = low + (high-low)/2
            
            if (mid == low or nums[mid-1]>nums[mid]) and (mid==high or nums[mid+1]>nums[mid]):
                return nums[mid]
            
            if nums[low]<=nums[mid]:
                low = mid + 1
            else:
                high = mid - 1