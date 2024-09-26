class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        first=self.binarySearchFirst(nums,target)
        if first==None:
            return [-1,-1]
        second=self.binarySearchLast(nums,target)
        if second==None:
            return [-1,-1]
        
        return [first,second]
        
    def binarySearchFirst(self,nums,target):
        low=0
        high=len(nums)-1
        
        while low<=high:
            mid=low+(high-low)//2
            
            if nums[mid]==target:
                if mid==0 or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high=mid-1
            elif target<nums[mid]:
                high=mid-1
            else:
                low=mid+1
                
                
    def binarySearchLast(self,nums,target):
        low=0
        high=len(nums)-1
        
        while low<=high:
            mid=low+(high-low)//2
            
            if nums[mid]==target:
                if mid==len(nums)-1 or nums[mid+1]>nums[mid]:
                    return mid
                else:
                    low=mid+1
            elif target>nums[mid]:
                low=mid+1
            else:
                high=mid-1
                
        
        