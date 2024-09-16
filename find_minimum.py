class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = (low + high) // 2
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid+1] > nums[mid]):
                return nums[mid]
            elif nums[mid] < nums[high]:
                high = mid - 1
            else:
                low = mid + 1
