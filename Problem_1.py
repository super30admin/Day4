"""Most of the test cases were successful, initially failed for an array of size 1,2,3 hence used brute force approach in the conditioning but later was unable to pass for a few conditions """

"""class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums)-1
        if len(nums)==1:
            if nums[0]==target:
                return 0,0
            else: 
                return -1,-1
        if len(nums)==2:
            if nums[0]==target:
                if nums[1] == target:
                    return 0,1
                else :
                    return 0,0
            
            if nums[1]==target:
                if nums[0] == target:
                    return 0,1
                else :
                    return 1,1
             
        while low <= high:
            mid = low + (high - low)//2
            if target == nums[mid]:
                if low == 0 and high == 0:
                    return 0,0
                elif mid == len(nums)-1:
                    return mid,mid
                elif nums[mid-1]==nums[mid+1]:
                    return mid-1,mid+1
                elif nums[mid]==nums[mid-1]:
                    return mid-1,mid
                elif nums[mid]==nums[mid+1]:
                    return mid,mid+1
                else:
                    return mid,mid
                
            if target < nums[mid]:
                high = mid - 1 
            else:
                low = mid + 1
                
        return -1,-1
                
                
 """

 class Solution:
    
    def SearchLeft(self,nums : List[int], target : int) -> int:
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = low + (high - low)//2
            if target == nums[mid]:
                if mid == 0 or nums[mid] > nums[mid-1]:
                    return mid
                else :
                    high = mid - 1
            elif target < nums[mid]:
                high = mid -1
            else:
                low = mid + 1
                
        return -1
    
    def SearchRight(self,nums : List[int], target : int) -> int:
        low = 0
        high = len(nums) - 1
        
        while low<=high:
            mid = low + (high - low)//2
            if nums[mid]==target:
                if mid == len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif target< nums[mid]:
                high = mid -1
            else:
                low = mid + 1
        return -1 
         
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums)==1 :
            if target == nums[0]:
                return 0,0
            else :
                return -1,-1
        
        if len(nums)==0:
            i = -1
            j = -1
        if len(nums)==2:
            if target == nums[0]:
                i = 0
                if target == nums[1]:
                    j = 1
            elif target == nums[1]:
                j = 1
                i = 1
            else :
                i = -1
                j = -1
            
                
        
        i = self.SearchLeft(nums, target)
        if i == -1:
            return -1,-1
        j = self.SearchRight(nums,target)
        
        return i,j
        
                
        
                
                
               