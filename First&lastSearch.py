class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def first():
            low,high = 0,len(nums)-1
            
            while low <= high:
                mid = low + (high-low)//2
                
                if nums[mid] == target and (mid==0 or nums[mid-1] != target):
                    return mid
                elif target > nums[mid]:
                    #go right
                    low = mid+1
                else:
                    #go left
                    high = mid-1
                    
            return -1
        
        def last():
            low,high = 0,len(nums)-1
            
            while low <= high:
                mid = low + (high-low)//2
                
                while low <= high:
                    mid = low+(high-low)//2
                    
                    if nums[mid] == target and (mid == len(nums)-1 or nums[mid+1] != target):
                        return mid
                    elif target < nums[mid]:
                        #go left
                        high = mid-1
                    else:
                        #go right
                        low = mid+1
                        
            return -1
        
        
        first = first()
        last = last()
        
        return [first,last]
