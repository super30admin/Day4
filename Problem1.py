"""
// Time Complexity : o(log n), where n  is the number of elements 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""

class Solution(object):
    def leftBinSearch(self, nums, target): #for finding the first index
        l = 0
        h = len(nums)-1
        
        while(l <= h):
            mid = l + (h-l)//2
            
            if nums[mid] == target: #we have found the target value
                if mid == 0 or nums[mid] > nums[mid-1]: #if the value before mid is smaller, that means mid is the first occurance, hence return index
                    return mid
                else: #else, reduce the search span by h = mid-1
                    h = mid-1
            elif nums[mid] > target: #when target hasnt been found, we update the l and h variables accordingly depending on the subarray to choose
                h = mid-1
            else:
                l = mid+1 
        return -1
    
    def rightBinSearch(self, nums, target):
        l = 0
        h = len(nums)-1
        
        while(l <= h):
            mid = l + (h-l)//2
            
            if nums[mid] == target:
                if  mid == len(nums)-1 or nums[mid] < nums[mid+1]: #if the value after mid is larger, that means mid is the last occurance, hence return index
                    return mid
                else:
                    l = mid+1 #else, reduce the search span by l = mid+1
            elif nums[mid] > target:
                h = mid-1
            else:
                l = mid+1 
        return -1
    
    
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        if not nums:
            return [-1,-1]
        f = self.leftBinSearch(nums,target)
        l = self.rightBinSearch(nums,target)
        
        return [f,l]