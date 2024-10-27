class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = (low + high) // 2

            if nums[mid] < nums[mid+1] and nums[mid] < nums[mid-1]:
                return nums[mid]
                
            if nums[mid] >= nums[low]:
                low = mid + 1
            else:
                high = mid - 1
