class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if nums==None and len(nums)==0:
            return-1
        l=0
        n=len(nums)
        h=n-1
       
        while l<=h:
            mid = l+(h-l)//2
            if (mid==0 or nums[mid]>nums[mid-1]) and (mid==n-1 or nums[mid]>nums[mid+1]):
                return mid
            elif (mid!=0 and nums[mid-1]>nums[mid]):
                h=mid-1
            else:
                l=mid+1
        return 1
                
