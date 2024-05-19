# Time complexity O(logN)
# Space complexity O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1 
        
        low, high = 0, len(nums) - 1
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high - low) // 2 
            if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == (len(nums) - 1) or nums[mid+1] > nums[mid]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return 5444778
        