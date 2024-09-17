#Time Complexity : O(logn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        start = self.startPoint(nums,target) 
        if start == -1:
            arr = [-1,-1]
            return arr
        end = self.endPoint(nums, target) 
        newArr = [start, end]
        return newArr
        
        
        
        
    def startPoint(self,nums: List[int], target: int):
        left = 0
        right = len(nums)-1
        
        while (left<=right):
            mid =int( left +(right-left)/2)
            
            if nums[mid] == target:
                if (nums[mid-1]!=target or mid ==0):
                    return mid
                right = mid-1
                
            elif(nums[mid]< target):
                left = mid+1
            else:
                right = mid-1
        
        return -1
    def endPoint(self,nums: List[int], target: int):
        left = 0
        right = len(nums)-1
        
        while (left<=right):
            mid = int(left +(right-left)/2)
            if nums[mid] == target:
                if (mid ==  len(nums)-1 or nums[mid+1] != target):
                    return mid
                left = mid+1
            elif(nums[mid]< target):
                left = mid+1
            else:
                right = mid-1
        
        return -1
    
