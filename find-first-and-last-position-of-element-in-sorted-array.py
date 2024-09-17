# Time Complexity : O(log n)
# Space Complexity: O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0 or nums == None:
            return [-1, -1]
        
        if target < nums[0] or target > nums[-1]:
            return [-1, -1]
        
        left = self.BinarySearchLeft(nums, target)
        
        if left == -1:
            return [-1, -1]
        
        right = self.BinarySearchRight(nums, target, left)
        
        return [left, right]
    
    def BinarySearchLeft(self, nums: List[int], target: int) -> int:
        low = 0
        n = len(nums)
        high = n - 1  
        
        while(low <= high):
            mid = low + (high - low) // 2   # Prevent integer overflow
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < nums[mid]:
                    return mid
                high = mid - 1
                
            elif target < nums[mid]:
                high = mid - 1
            
            else:
                low = mid + 1
        
        return -1
    
    def BinarySearchRight(self, nums: List[int], target: int, left: int) -> int:
        low = left
        n = len(nums)
        high = n - 1
        
        while(low <= high):
            mid = low + (high - low) // 2   # Prevent integer overflow
            
            if nums[mid] == target:
                if mid == n - 1 or nums[mid+1] > nums[mid]:
                    return mid
                low = mid + 1
                
            elif target > nums[mid]:
                low = mid + 1
                
            else:
                high = mid - 1
        
        return -1
                
                
            