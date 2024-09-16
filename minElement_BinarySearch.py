class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while low<=high:
            if nums[low]<=nums[high]:
                return nums[low]
            mid = low+(high-low)//2
            if ((nums[mid]<nums[mid-1] or mid == low) and  (nums[mid]<nums[mid+1] or mid == high)):
                return nums[mid]
            elif nums[mid]>nums[high]:
                low = mid+1
            else:
                high = mid-1
        return -1
        
""" This implementation takes O(log(n)) complexity as
 we used binary search to find minimum element"""