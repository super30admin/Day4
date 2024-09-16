"""
// Time Complexity : o(log n), where n  is the number of elements 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        
        """

        
        l = 0
        h = len(nums)-1
        
        if len(nums)==1:
            return nums[0]
        
        while (l<=h):
            
            mid = l + (h-l)//2
            '''
            #if mid == 0 or mid == len(nums)-1:
             #   return nums[mid]
            '''
            if nums[l]<=nums[h]: #case when nums subarray is not rotated, then first element will be the smallest
                return nums[l]


            if mid == len(nums)-1: #if mid is at the last element, return value
                return nums[mid]


            if nums[mid] < nums[mid-1] and nums[mid] < nums[mid+1]: #if nums[mid] is smaller than its either neighbours, then its the smallest
                return nums[mid]
            '''
            #if nums[mid]>nums[l] and nums[mid]< nums[h]: #
            #   h = mid-1
            '''
            
            elif nums[l] <= nums[mid]: #if left subarray is sorted, disregard it and consider the unsorted subarray, hence set l=mid+1
                l=mid+1

            elif nums[mid] <= nums[h]: #if right subarray is sorted, disregard it and consider the unsorted subarray, hence set h=mid-1
                h=mid-1
            '''
            #elif mid == 0 or mid == len(nums)-1:
             #   return nums[mid]
            '''