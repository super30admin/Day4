class Solution:
    # Time Complexity - O(logN)
    # Space Complexity - O(1)
    def searchRange(self, nums, target):
        left = self.leftPosition(nums, target)
        right = self.rightPosition(nums, target)
        return [left, right]
        
    def leftPosition(self, nums, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if mid == low or nums[mid-1] != target:
                    return mid
                high = mid - 1
                    
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def rightPosition(self, nums, target):
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high-low) // 2
            if nums[mid] == target:
                if mid == high or nums[mid+1] != target:
                    return mid
                low = mid + 1
                    
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

            
        
        
        
        