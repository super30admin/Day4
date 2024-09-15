'''// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        #First check if the list is empty and then return None
        if len(nums)==0:
            return None
        
        
        low=0
        high=len(nums)-1
        
        while(low<=high):
            mid=low+(high-low)//2
            #Check if the list is sorted
            if nums[low]<=nums[high]:
                return nums[low]
            
            #Check if (mid is 1st position or elem at mid id < than mid-1 elem) and (mid is at last position or elem at mid is less than mid+1 elem)
            elif (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            
            #Check if the lhs is sorted and eliminate it 
            elif nums[low]<=nums[mid]:
                low=mid+1
            #else elimnate rhs
            else:
                high=mid-1
        return None
        
