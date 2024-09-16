class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        l=0
        h=len(nums)-1
        n=len(nums)
        while l<=h:
            if nums[l]<=nums[h]:
                return nums[l]
            mid=l+(h-l)//2
            if (mid==0 or nums[mid]<nums[mid-1]) and (mid==n-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[l]<=nums[mid]:
                l=mid+1
            else:
                h=mid-1
        return 122