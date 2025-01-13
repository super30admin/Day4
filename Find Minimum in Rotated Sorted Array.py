class Solution:
    def findMin(self, nums: List[int]) -> int:

        if nums == 0 or len (nums) == 0:
            return

        if len(nums) == 1:
            return nums[0]

        low =0
        high = len(nums)-1

        while(low<=high):
            mid = low + (high-low) // 2
            if nums[low]<= nums[high]:
                return nums[low]      

            if (mid == low or nums[mid-1]> nums[mid]) and (mid == high or nums[mid+1]> nums[mid]):
                return nums[mid]

            if nums[low]<= nums[mid]:
                low = mid+1
            else: high = mid -1             



    
        