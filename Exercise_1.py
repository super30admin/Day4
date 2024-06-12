class Solution:
    def binarysearchleft(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=int(low+(high-low)/2)
            if nums[mid]==target:
                if mid==0 or nums[mid]>nums[mid-1]:
                    low=mid
                    return mid
                else:
                    high=mid-1
                    
            elif nums[mid]>target:
                high=mid-1
                    
            else:
                low=mid+1
        return -1
    def binarysearchright(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=int(low+(high-low)/2)
            if nums[mid]==target:
                if mid==high or nums[mid]<nums[mid+1]:
                    low=mid
                    return mid
                else:
                    low=mid+1
                    
            elif nums[mid]>target:
                high=mid-1
                    
            else:
                low=mid+1
        return -1
                
                
               
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left=self.binarysearchleft(nums,target)
        right=self.binarysearchright(nums,target)
        return [left,right]