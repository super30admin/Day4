"""
// Time Complexity : o(log n), where n  is the number of elements 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        #simple binary search
        start=0
        last=len(nums)-1
        
        while start<last:
            mid=(start+last)/2
            if nums[mid]>nums[mid+1]:
                last=mid
            else:
                start=mid+1
        return last
        
        