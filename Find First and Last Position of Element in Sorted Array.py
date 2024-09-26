class Solution:
    def binarySearchFirst(self, nums: List[int], target: int) -> List[int]:
        low,high=0,len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid] == target:
                if mid==0 or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    high=mid-1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1
    
    def binarySearchLast(self, nums: List[int], target: int)-> List[int]:
        low,high=0,len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid] == target:
                if mid==len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    low=mid+1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums==None  or len(nums)==0:
            return [-1,-1]
        if nums[0]>target or nums[len(nums)-1]<target:
            return [-1,-1]
        first=self.binarySearchFirst(nums,target)
        last=self.binarySearchLast(nums,target)
        return [first,last]
                
