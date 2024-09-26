# Find First and Last Position of Element in Sorted Array#(https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/)
# Time complexity: O(log(n)); n=no of elements in array 
# Space complexity: O(1); 
# Did this code successfully run on Leetcode : Yes
# Approach: Binary Search

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) == 0:
            return [-1,-1]
        
        first = self.findFirst(nums, target)
        last = self.findLast(nums, target, first)
        return [first, last]
        
        
        
    def findFirst(self, arr, target):
        low = 0
        high = len(arr) - 1
        
        while low <= high:    
            mid = low + (high - low) // 2
    
            if arr[mid] == target:
            
                # Check if its the first occurence 
                # Check if left side contains such element or not 
                if mid == low or arr[mid] > arr[mid-1]:
                    return mid
                
                # Perform binary search on left side to find the element
                else:
                    high = mid - 1
                    
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1
    
    def findLast(self, arr, target, low):
        high = len(arr) - 1
        
        while low <= high:    
            mid = low + (high - low) // 2
    
            # Check if its the last occurence 
            # Check if right side contains such element or not 
            if arr[mid] == target:
                if mid == high or arr[mid] < arr[mid+1]:
                    return mid
                
                # Perform binary search on right side to find the element
                else:
                    low = mid + 1
                    
            elif arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
                
        return -1