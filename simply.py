class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        r=len(nums)-1
        while(l<=r):
            if(nums[l]<=nums[r]):
                return nums[l]
            if(r==1):
                return min(nums)
            mid=(l+r)//2
            
            if(mid==0 or nums[mid]<nums[mid-1] or mid==len(nums)-1 or nums[mid]==nums[mid+1]):
                return nums[mid]
            elif nums[l]<=nums[mid] :
                l=mid+1
            else:
                r=mid-1
        return -1     