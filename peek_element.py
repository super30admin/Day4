class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0:
            return -1
        l,h=0,len(nums)-1
        while l<=h:
            mid=l+(h-l)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid>0 and nums[mid-1]>nums[mid]:
                h=mid-1
            else:
                l=mid+1
                
        return -1