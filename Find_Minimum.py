class Solution:
    def findMin(self, nums: List[int]) -> int:
        res=nums[0]
        start=0
        end=len(nums)-1
        while start<=end:
            if nums[start]<nums[end]:
                res=min(res,nums[start])
                break
            
            mid=(start+end)//2
            res=min(res,nums[mid])
            if nums[mid]>=nums[start]:
                start=mid+1
            elif nums[mid]<nums[start]: #else:
                end=mid-1
        return res