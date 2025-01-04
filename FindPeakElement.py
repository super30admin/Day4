class Solution:
   def findPeakElement(self, nums: List[int]) -> int:
    low, high = 0, len(nums) - 1
    
    while low <= high:
        mid = (low + high) // 2
        
        # Check if `mid` is a peak
        if ((mid == 0 or nums[mid] > nums[mid - 1]) and
            (mid == len(nums) - 1 or nums[mid] > nums[mid + 1])):
            return mid
        
        # If the left neighbor is greater, move left
        elif mid > 0 and nums[mid] < nums[mid - 1]:
            high = mid - 1
        
        # Otherwise, move right
        else:
            low = mid + 1
#---------------------Always move toward higher side---------------------------------
        

        