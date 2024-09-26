""" Time Complexity : O(log n)
Space Complexity : O(1)
Did it run on Leetcode : Yes """

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(len(nums)==0):
            return [-1, -1]
        
        
        
        first = self.binarySearchFirst(nums,target)
        second = self.binarySearchSecond(nums,target)
        return(first,second)
   
    def binarySearchFirst(self,nums,target):
        low =0
        high = len(nums)-1
        
        while(low<=high):
            mid = int(low + ((high-low)/2))
            
            if((mid != 0 and nums[mid]==target and nums[mid]==nums[mid-1]) or nums[mid]>target):
                high=mid-1
            elif(nums[mid]==target):
                return mid
            else:
                low=mid+1
        return -1
    
    def binarySearchSecond(self, nums, target):
        low =0
        high = len(nums)-1
        
        while(low<=high):
            mid = int(low + ((high-low)/2))
            
            if((mid != len(nums)-1 and nums[mid]==target and nums[mid]==nums[mid+1]) or nums[mid]<target):
                low=mid+1
            elif(nums[mid]==target):
                return mid
            else:
                high=mid-1
        return -1
            
            
        
        
        