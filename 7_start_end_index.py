# S30 Big N Problem #7 {Medium }

# Given an sorted array, find the first and last position of a given element.
# Your algorithm's runtime complexity must be O(log n).
# If the target is not found in the array, return [-1, -1].

#Time Complexity : O(logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        
        low=0
        high=len(nums)-1
        
        while low<=high:
            
            mid=low+(high-low)//2
            if nums[mid]==target:
                left=self.leftSearch(nums,low,mid,target)
                right=self.rightSearch(nums,mid,high,target)
                return [left,right]
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        
        return [-1,-1]
                
    def leftSearch(self,nums,low,high,target):
        
        while low<=high:
            
            mid=low+(high-low)//2
            
            print(mid,low,high)
            if nums[mid]==target:
                
                if mid==low or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    high=mid-1
            else:
                low=mid+1
        
            
    def rightSearch(self,nums,low,high,target):
        
        while low<=high:
            
            mid=low+(high-low)//2
            
            if nums[mid]==target:
                
                if mid==high or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    low=mid+1
            else:
                high=mid-1
                
        
                
        