'''https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/'''

# Time Complexity : O(Log(N)) where N: # of elements in nums
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums is None or len(nums) == 0:
            return [-1, -1]
        
        first = self.searchFirst(nums, target)
        if first == -1: # if num not found
            return [-1, -1]
        second = self.searchLast(nums, target)
        return [first, second]        
        
    
    def searchFirst(self, nums: List[int], target: int):
        # Binary Search for first occurence of target
        low = 0
        high = len(nums) - 1 
        while low <= high:
            mid = int(low + (high-low)/2)
            if nums[mid] == target:
                if mid == 0 or ( mid > 0 and nums[mid-1] != target): # first element
                    return mid
                else:
                    high = mid - 1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
    
    
    def searchLast(self, nums: List[int], target: int):
        # Binary Search for last occurence of target
        low = 0
        high = len(nums) - 1 
        while low <= high:
            mid = int(low + (high-low)/2)
            if nums[mid] == target:
                if mid == len(nums)-1 or (mid != len(nums)-1 and nums[mid+1] != target): # last element
                    return mid
                else:
                    low = mid+1
            elif target < nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
                
                    
            
        