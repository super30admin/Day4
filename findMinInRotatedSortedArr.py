# Time complexity -> O(logN)
# Space complexity -> O(1)


class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        low = 0
        high = len(nums) - 1
        
        while low<= high:
            if nums[low] < nums[high]:
                return nums[0]
            
            mid = low + high-low//2 
            
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            
            if nums[mid] < nums[low]:
                high = mid-1
            else:
                low = mid+1 