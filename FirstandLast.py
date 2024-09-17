class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums)==0:
            return [-1,-1]
        first=self.binarySearchLeft(nums,target)
        last=self.binarySearchRight(nums,target)
        return [first,last]
    def binarySearchLeft(self,nums,target):
        low=0
        high=len(nums)-1
        
        while(low<=high):
            mid=(low+high)//2
            if nums[mid]==target:
                
                
                if mid==0 or nums[mid]>nums[mid-1]:
                    return mid
                
                else:
                    high=mid-1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1
    
    def binarySearchRight(self,nums,target):
        low=0
        high=len(nums)-1
        
        while(low<=high):
            mid=(low+high)//2
            if nums[mid]==target: 
                
               
                if mid==len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    low=mid+1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1
    
