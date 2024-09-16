class Solution:
    def searchRange(self, nums, target: int):
        if not nums:
            return [-1, -1]
        
        first = self.binarySearch(nums, target, False)
        last = self.binarySearch(nums, target, True)
        
        return [first, last]
    
    def binarySearch(self, nums, target, last):
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = low + (high - low)//2
            
            if nums[mid] == target:
                # first occurance
                if not last: # searching for first occurance logic
                    if ((mid == 0) or (nums[mid]>nums[mid-1])): # mid == 0 check because what if there is onle one element
                        return mid
                    else:
                        high = mid - 1
                
                # last occurance
                else:
                    if((mid == len(nums) - 1) or (nums[mid] < nums[mid + 1])): # to check if reached the last occurance
                        return mid
                    else:
                        low = mid + 1
                        
            
            elif nums[mid]>target:
                high = mid - 1
            else:
                low = mid + 1
                
        return -1
    
    # TC: O(log n)
    # SC: O(1)
