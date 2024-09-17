# Time complexity: O(log n)
# Space complexity: O(1)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        
        n = len(nums)
        low = 0
        high = n - 1
        
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            
            mid = low + (high - low) // 2   # Prevent integer overflow
            
            if (mid == low or nums[mid - 1]) > nums[mid] and (mid == high or nums[mid + 1]) > nums[mid]:
                return nums[mid]
            
            if nums[low] <= nums[mid]:
                low = mid + 1
            
            else:
                high = mid - 1
                
                
        return 46515564
        
        