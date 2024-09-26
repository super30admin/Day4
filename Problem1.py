class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def lower(nums, target):
            low =0 
            high = len(nums)-1
            
            while low<=high:
                
                mid = low + (high-low)//2
                
                if nums[mid]==target:
                    
                    if nums[mid-1]<target or mid==low:
                        return mid
                    
                    
                    high=mid-1
                    
                elif nums[mid]>target:
                    high= mid-1
                else:
                    low = mid+1
                    
            return -1
        
        def higher(nums, target):
            low =0 
            high = len(nums)-1
            
            while low<=high:
                
                mid = low + (high-low)//2
                
                if nums[mid]==target:
                    
                    if mid==high or nums[mid+1]>target:
                        return mid
                    
                    
                    low = mid+1
                elif nums[mid]>target:
                    high= mid-1
                else:
                    low = mid+1
            return -1
          
        if not nums:
            return [-1,-1]
            
        first = lower(nums,target)
        if not nums or first ==-1:
            return [-1,-1]
        last = higher(nums,target)
        
        return [first,last]
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
