'''// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach '''
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #Taking care of the edge cases
        
        #If the array is empty
        if len(nums) == 0:
            return -1
        #If the array has only one element
        if len(nums) == 1:
            return 0

        
        l = 0
        h = len(nums)-1

        while l<=h:
            mid= l + (h-l)/2
            #To check if the peak is the first element
            if mid == 0 and nums[mid] > nums[mid+1]:
                return mid
            
            #To check if the peak is the last element
            elif mid == h and nums[mid] > nums[mid-1]:
                return mid
            
            #cgeck if the middle element is a peak
            elif nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return mid
            elif nums[mid+1]>nums[mid]:
                l = mid + 1
            else:
                h = mid - 1
    
