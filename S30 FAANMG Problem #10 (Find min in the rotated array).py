class Solution:
    
    def findMin(nums):
        n = len(nums)
        low = 0 
        high = n - 1
        
        while(low<=high):
            if(nums[low] <= nums[high]):
                return nums[low]
            mid = low + (high-low) // 2
            
            if((mid == 0 or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid + 1])):
                return nums[mid]
            
            if(nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid - 1
        
nums = [3,4,5,1,2]
print(Solution.findMin(nums))

