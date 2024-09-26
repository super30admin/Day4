import math
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        if len(nums) == 1:
            return nums[0]
        while(low<=high):
            mid = math.floor(low+(high-low)/2)
            if((mid == 0 or nums[mid-1]>nums[mid]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1])) :
                return nums[mid]
            elif nums[mid]<nums[high]:
                high = mid-1
            else:
                low = mid+1
        return -1

        
