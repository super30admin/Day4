class Solution:
    def searchRange(self, nums, target: int):
        low=self.BinarySearch(nums,target,True)
        high=self.BinarySearch(nums,target,False)
        return [low,high]
        
    def BinarySearch(self,nums,target,LeftCheck):
        l,h=0,len(nums)-1
        i=-1
        while l<=h:
            mid=(l+h)//2
            if nums[mid]>target:
                h=mid-1
            elif nums[mid]<target:
                l=mid+1
            else:
                i=mid
                if LeftCheck:
                    h=mid-1
                else:
                    l=mid+1
        return i
        