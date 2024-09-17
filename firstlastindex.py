class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low=0
        high=len(nums)-1
        
        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target:
                return [self.firstindex(nums,target,low,high), self.lastindex(nums,target,low,high)]
            elif nums[mid]<target:
                low=mid+1
            elif nums[mid]>target:
                high=mid-1
        return [-1,-1]
            
    def firstindex(self, nums,target,low,high):
        first=0
        while low<=high:
            mid=(high+low)//2
            if nums[mid]==target:
                first=mid
                high=mid-1
            elif nums[mid]<target:
                low=mid+1
        return first
    
    
    def lastindex(self, nums,target,low,high):
        last=0 
        while (low <= high):
            mid = low + int((high - low) / 2)
            if (nums[mid]==target):
                last = mid
                low=mid+1
            elif nums[mid]>target:
                high=mid-1
        return last
    
    
        