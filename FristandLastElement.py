class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==0 or nums==None:
            return [-1,-1]
        first=self.binarysearchfirst(nums,target)
        if first==-1:
            return[-1,-1]
        last=self.binarysearchlast(nums,target)
        return[first,last]
    def binarysearchfirst(self, nums: List[int], target: int) -> List[int]:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid]==target:
                if (mid==0) or (nums[mid]!=nums[mid-1]):
                    return mid
                else:
                    high=mid-1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1   
        return -1
    def binarysearchlast(self, nums: List[int], target: int) -> List[int]:
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if nums[mid]==target:
                if (mid==len(nums)-1) or nums[mid]!=nums[mid+1]:
                    return mid
                else:
                   low=mid+1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1   
        return -1    