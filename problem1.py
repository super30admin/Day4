#Brute Force
#Time Complexity O(n)
#Space Complexity O(1)



class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if len(nums)==0:
            return [-1,-1]
        
        if len(nums)==1 and nums[0]==target:
            return [0,0]
        
        if len(nums)==1 and nums[0]!=target:
            return [-1,-1]
        
        p1 = -1
        p2 = -1
        
        for x in range(len(nums)):
            if nums[x] == target:
                p1 = x
                break
        for x in range(len(nums)-1,-1,-1):
            if nums[x] == target:
                p2 = x
                break
        return [p1,p2]
                
            
        
            
        
        
                

       
        
        
       
                        
        
        
        
        
        
        
        
