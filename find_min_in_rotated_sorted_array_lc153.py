"""
Author: Srinidhi Bhat
Did the code run on Leetcode: Yes
Time Complexity : O(logN)
Space Complexity: O(1)

Logic: Since it is rotated about a point, we have to find this point which will be lower peak
When ever you calculate mid 3 cases arise:
1. Compare with neighbours - (it could be left neighbour or right neighbour is of lesser value and hence the lower peak)
2. Compare with the first element - that will help in deciding if to go to right half or left half. 
"""
class Solution:
    def getMin(self,nums,start,end):
        #if the array is not rotated, then last number will be greater
        #then the first one 
        #this is because after rotation, smaller elements go to the back
        if nums[0] < nums[end]:
            return nums[0]
        
        while end >= start:
            mid = start + (end-start)//2
            #if mid+1 is lesser, it is lower peak
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            #if mid-1 is lesser, it is the lower peak
            if nums[mid-1] > nums[mid]:
                return nums[mid]
            
            #if mid is greater than first element, all the elements are greater, hence search for second half
            if nums[mid] > nums[0]:
                start = mid + 1
            #else, search in second half
            else:
                end = mid - 1
            
            
            
    def findMin(self, nums: List[int]) -> int:
        #base cases.
        if len(nums)==0:
            return 0
        
        if len(nums)==1:
            return nums[0]
        
        start = 0
        end = len(nums)-1
        return self.getMin(nums,start,end)