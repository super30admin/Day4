class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums== None or len(nums)==0:
            return [-1,-1]
        
        leftIdx=self.bSearchL(nums,target)
        rightIdx=self.bSearchR(nums,target)
        
        return [leftIdx,rightIdx]

    def bSearchL(self,nums,target):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2 #python will not have int overflow 
            print(low,mid,high)
            if nums[mid]==target:
                if(mid==low or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    high=mid-1
            elif(nums[mid]<target):
                low=mid+1
            
            else:
                high=mid-1
        return -1
    
    def bSearchR(self,nums,target):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2 #python will not have int overflow 
            if nums[mid]==target:
                if(mid==high or nums[mid]<nums[mid+1]):
                    return mid
                else:
                    low=mid+1
            elif(nums[mid]<target):
                low=mid+1
            
            else:
                high=mid-1
        return -1
    
        