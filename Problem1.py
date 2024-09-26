import math


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        val1 = self.binarysearchleft(nums,target,low,high)
        if val1 == -1:
            return [-1,-1]
        val2 = self.binarysearchright(nums,target,low,high)
        if val2 != -1:
            return [val1,val2]
        else:
            return [-1,-1]
    def binarysearchleft(self,nums,target,low,high):
        while(low<=high):
            mid = math.floor(low+(high-low)/2)
            if ((nums[mid]==target) and (mid==0 or nums[mid-1]< nums[mid]) ):
                return mid
            elif nums[mid]<target:
                low = mid+1
            else:
                high = mid-1
        return -1

    def binarysearchright(self,nums,target,low,high):
        while(low<=high):
            mid = math.floor(low+(high-low)/2)
            if ((nums[mid]==target) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]) ):
                return mid
            elif nums[mid]>target:
                high = mid-1
            else:
                low = mid+1
        return -1

        
