#Time complexity:O(logn)
#sapce complexity: O(1)
class Solution:
    def searchRange(self, nums, target: int):
        low,high=0,len(nums)-1
        temp1,temp=-1,-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid]>target:
                high=mid-1
            elif nums[mid]<=target:
                if nums[mid]==target:
                    temp=mid
                low=mid+1
        low,high=0,len(nums)-1
        while low<=high:
            mid=(low+high)//2
            if nums[mid]<target:
                low=mid+1
            elif nums[mid]>=target:
                if nums[mid]==target:
                    temp1=mid
                high=mid-1
        return [temp1,temp]
            
                
                
                
        