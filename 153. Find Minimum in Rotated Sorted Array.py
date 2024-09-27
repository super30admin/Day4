class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return -1
        n = len(nums)
        low = 0
        high = n-1
        while(low<=high):
            if nums[low]<=nums[high]:
                return nums[low]
            mid = (low+high) //2
            if ((mid ==0 or nums[mid-1]> nums[mid]) and (mid == n-1 or nums[mid+1]>nums[mid])):
                return nums[mid]
            if (nums[low] <= nums[mid]):
                low = mid+1
            else:
                high = mid+1
        return 4374632
            

        
        