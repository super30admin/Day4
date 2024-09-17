class Solution:
    
    def BinarySearchFirst(self,nums, target, low, high):

        ### Binary Search
        while low <= high:
            mid = low + (high-low)//2
            
            if nums[mid] == target:
                if (mid == low) or nums[mid] > nums[mid-1]:
                    return mid
                else:
                    high = mid-1
            
            elif nums[mid] < target:
                low = mid+1
                
            else:
                high = mid-1
                
        return -1
        
    def BinarySearchLast(self,nums, target, low, high):

        ### Binary Search
        while low <= high:
            mid = low + (high-low)//2
            
            if nums[mid] == target:
                if (mid == high) or nums[mid] < nums[mid+1]:
                    return mid
                else:
                    low = mid+1
            
            elif nums[mid] < target:
                low = mid+1
            
            else:
                high = mid-1
                
        return -1
        
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        ### Edge Case 1
        if nums is None or not len(nums):
            return [-1,-1]
        
        low, high = 0, len(nums)-1
        
        ### Edge Case 2
        if target < nums[low] or target > nums[high]:
            return [-1,-1]
        
        start_position = self.BinarySearchFirst(nums, target, low, high)
        end_position = self.BinarySearchLast(nums, target, start_position, high) if start_position > -1 else -1
        
        return [start_position, end_position]


### Complexity Analysis ###

## Time Complexity: O(logN) --> Two Pass Binary Search in worst case
## Space Complexity: O(1) --> No Extra Space Used