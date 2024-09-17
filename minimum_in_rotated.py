class Solution:
    def findMin(self, nums: List[int]) -> int:
        l,h=0,len(nums)-1
        while l<=h:
            mid=(l+h)//2
            if nums[l]<=nums[h]:
                return nums[l]
            if ((mid==0 or nums[mid]<nums[mid-1]) and ((len(nums)-1==0) or nums[mid]<nums[mid+1])):
                return nums[mid]
            elif nums[l]<=nums[mid]:
                l=mid+1
            else:
                h=mid-1
        return -1