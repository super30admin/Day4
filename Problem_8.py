# Time Complexity : O(logn) sicne we are applying binary search twice
# Space Complexity : No auxiliary space needed. O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def findLeft(nums,target,low,high):
            while low<=high:
                mid = low + (high-low)//2
                if nums[mid]==target: # Check mid element with target
                    if mid==0:
                        return mid # If mid is the first element it is the start of our range
                    if nums[mid]==nums[mid-1]:
                        high = mid-1 # If mid-1 is same as mid then update high to mid-1. This means mid is not the start of our range and we should continue searching on left half.
                    else:
                        return mid # If mid-1 is a different element then mid is the start of the range
                elif nums[mid]>target:
                    high = mid-1 # If mid element is greater than target check left half
                else:
                    low = mid+1 # Else check right half
            return -1
        
        def findRight(nums,target,low,high):
            while low<=high:
                mid = low + (high-low)//2
                if nums[mid]==target:
                    if mid==len(nums)-1:
                        return mid # If mid is the last element of gthe array it is the start of our range
                    if nums[mid]==nums[mid+1]:
                        low = mid+1  # If mid+1 is same as mid then update low to mid+1. This means mid is not the end of our range and we should continue searching
                    else:
                        return mid # If mid+1 is a different element then mid is the end of the range
                elif nums[mid]>target:
                    high = mid-1 # If mid element is greater than target check left half
                else:
                    low = mid+1 # Else check right half
            return -1
        
        if not nums:
            return [-1,-1] # Edge case nums is empty
                
        x = findLeft(nums,target,0,len(nums)-1)
        if x == -1:
            return [-1,-1]   # No need to call second function if first is already -1
        return [x,findRight(nums,target,x,len(nums)-1)] # In the findRight give low as return value of findLeft