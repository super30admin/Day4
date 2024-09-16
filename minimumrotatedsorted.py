# Time Complexity : O(LOGN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No




class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1

         
        while low <= high:
            
            
            mid = low + (high - low)/2
        
            if low == high:
                return nums[mid]
            
            if mid > low and nums[mid] < nums[mid-1]:
                return nums[mid]
            
            if  mid < high and nums[mid] > nums[mid+1] :
                return nums[mid+1]
            
            if nums[mid] < nums[high]:
                high = mid - 1
            else:
                low = mid + 1
        return nums[0]        
                
                
                
            
            