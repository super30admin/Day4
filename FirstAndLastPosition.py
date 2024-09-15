'''// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach '''
class Solution(object):
    
    #Find start position
    def BinarySearchFirst(self, nums, target):
        
        l = 0
        h = len(nums)-1
        
        while(l<=h):
            mid=l+(h-l)//2
            if nums[mid]==target:
                #If the start position is the first element
                if mid == 0:
                    return mid
                #check if the previous element is not equal
                elif nums[mid-1] < nums[mid]:
                    return mid
                #If it is equal then repeat 
                else:
                    h = mid - 1 
            elif target > nums[mid]:
                l = mid + 1
            else:
                h = mid -1
                
                
        return -1
    
    
    #Find the end position
    def BinarySearchEnd(self, nums, target, l, h):
        
        while(l<=h):
            mid=l+(h-l)//2
            if nums[mid]==target:
                #If the end position is the end of the list
                if mid == h:
                    return mid
                #Check if the next element is greater than the current element
                elif nums[mid+1] > nums[mid]:
                    return mid
                else:
                    l = mid + 1 
            elif target > nums[mid]:
                l = mid + 1
            else:
                h = mid -1
                
        return mid
                
                
        return -1
    
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #Edge cases --> Intial If the list is empty or if the target is not in range
        #If list is empty
        if len(nums) == 0:
            return [-1, -1]
        
        #If target not in range
        if nums[0]> target or nums[len(nums)-1]< target:
            return [-1, -1]
        
        startPosition=self.BinarySearchFirst(nums, target)
        
        #If element not in list return [-1, -1]
        if startPosition == -1:
            return [-1,-1]
        
        endPosition=self.BinarySearchEnd(nums, target, startPosition, len(nums)-1)
        
        return [startPosition, endPosition]
        
                
        
        
