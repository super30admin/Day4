class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            
            mid = (left + right) // 2
            
            if (((mid == len(nums) - 1) or (nums[mid] > nums[mid + 1])) and ((mid == 0) or (nums[mid] > nums[mid - 1]))): # Checking if mid is at last index 
                               # Checking if mid is at first index 
                               # if any of those conditions are true and the other satisfies 
                               # return the mid index
                return mid
            
            if (nums[mid + 1] > nums[mid]):
                left = mid + 1
            else:
                right = mid - 1
        return -1
    
    # Time Complexity: O(log(n))
    # Space Complexity: O(1)