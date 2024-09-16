
# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0: # Base case must be mention in interview
            return -1
        
        low = 0
        high = len(nums) - 1
        
        #perform binary search
        while low <= high:
            mid = low + (high - low)//2
            #check the boundaries
            if ((mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
        
                return mid 
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            
            else:
                low = mid + 1
        return -1