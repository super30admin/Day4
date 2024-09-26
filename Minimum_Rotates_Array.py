class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if nums[0]<=nums[len(nums)-1]:
            return nums[0]
        
        low=0
        high=len(nums)-1
        
        while low<=high:
            mid=low+(high-low)//2
            
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            
            elif nums[low]<=nums[high]:
                return nums[low]
            
            elif nums[low]<=nums[mid]:
                low=mid+1
                
            else:
                high=mid-1