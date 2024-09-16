class Solution:
    def findMin(self, nums):
        # Brute force way:
        # Sort the array and return the 1st element of the array. TC = O(n)
        
#         nums.sort() 
#         return nums[0]
    
        #Binary search
        
        low = 0
        high = len(nums) - 1
        if nums[low] < nums[high]:
            return nums[low]
        while(low <= high):
            if nums[low] < nums[high]:
                return nums[low]
            
            mid = (low + high)//2
            if (mid == 0 or nums[mid - 1] > nums[mid]) and (mid == len(nums)-1 or nums[mid + 1] > nums[mid]):
                return nums[mid]
            elif (nums[low] <= nums[mid]):
                low = mid + 1
            else:
                high = mid - 1
            
            