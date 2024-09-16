class Solution:
    def findMin(self, nums) -> int:
        if not nums:
            return -1
        
        low = 0
        high = len(nums) - 1
        
        while (low<=high):
            mid = low + (high - low)//2
            
            if (nums[low]<nums[high]):
                return nums[low]
            
            # check if min
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            
            #check if sorted
            elif (nums[mid]>=nums[low]):
                low = mid + 1
            
            else:
                high = mid -1 
        
        return -1
    
    # TC: O(log n)
    # SC: O(1)
