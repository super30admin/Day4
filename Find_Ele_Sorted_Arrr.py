class Solution:   
    
    def binarySearchLeft(self, nums, target):
        
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            
            mid = (low + high) // 2

            if nums[mid] == target:
                
                
                #EXTRA CONDITION TO SEARCH FOR LEFT MOST INDEX
                if mid == 0 or nums[mid] > nums[mid-1]:
                    
                    return mid
                
                else:
                     high = mid - 1
                        
            elif nums[mid] > target:
                
                
                high = mid - 1
                
            else:
                
                low = mid + 1
                
        return -1
    
    
    def binarySearchRight(self, nums, target):
        
        low = 0
        high = len(nums) - 1
        
        while(low <= high):
            
            mid = (low + high) // 2

            if nums[mid] == target:
                
                
                #EXTRA CONDITION TO SEARCH FOR RIGHT MOST INDEX
                if mid == len(nums)-1 or nums[mid] < nums[mid+1]:
                    
                    return mid
                
                else:
                     low = mid + 1
                        
            elif nums[mid] > target:
                
                
                high = mid - 1
                
            else:
                
                low = mid + 1
                
        return -1
    
    
    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums) == 0 or target < nums[0] or target > nums[-1]:
            return [-1, -1]
        
        left = self.binarySearchLeft(nums, target)
        right = self.binarySearchRight(nums, target)
        
        return [left, right]
        
