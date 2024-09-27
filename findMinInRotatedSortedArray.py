class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        
        low, high = 0, len(nums)-1
        
        while low<=high:
            
            mid = (low+high)//2
            
            if nums[low]<nums[high]:
                return nums[low]
            
            if (mid == len(nums)-1 or nums[mid] < nums[mid+1]) and (mid == 0 or nums[mid] < nums[mid-1]):
                return nums[mid]
            
            elif nums[mid] >=nums[low]:
                low = mid + 1
            else:
                high = mid -1
        
#  Time complexity is log n
#  Approach is to go towards the unsorted part...as you are essentially just looking for the pivot.
#  Exception is that we fail to handle if both sides are sorted so we add one condition to check that and return first element if both sides are sorted.
        
