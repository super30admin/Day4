class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        low = 0
        high = len(nums) -1
        n = len(nums) - 1
        
        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            else:
                mid = (low + high) // 2
                
                if (mid == 0 or nums[mid-1] > nums[mid]) and (mid == n or nums[mid+1] > nums[mid]):
                    return nums[mid]
                elif (nums[low]<=nums[mid]):
                    low = mid + 1
                else:
                    high = mid - 1