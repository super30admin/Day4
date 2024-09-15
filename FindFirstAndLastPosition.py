//Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO




class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if  (len(nums)==0):
            return [-1,-1]
        if (target<nums[0]) or (target > nums [len(nums)-1]):
            return [-1,-1]
        left = self.binarySearchLeft(nums,target)
        if left== -1:
            return [-1,-1]
        right = self.binarySearchRight(nums,target)
        return [left,right]
    def binarySearchLeft(self,nums,target):
        low = 0
        high= len(nums)-1
        
        while(low<=high):
            mid = low + ( high-low)/2
            if(nums[mid]==target):
                if(mid ==0 or nums[mid-1]!=target):
                    return mid
                else:
                    high = mid -1   
            elif(nums[mid]>target):
                high = mid - 1
            else:
                low = mid + 1
        return -1   
    def binarySearchRight(self,nums,target):
        
        low = 0
        high= len(nums)-1
        
        while(low<=high):
            mid = low + ( high - low)/2 
            if(nums[mid]==target):
                if(mid == len(nums)-1 or  nums[mid+1]!=target):
                    return mid
                else:
                    low = mid + 1
                    
            elif(nums[mid]>target):
                high = mid - 1
            else:
                low = mid + 1
        return -1    