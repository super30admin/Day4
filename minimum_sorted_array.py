class Solution:
    def findMin(self, nums: List[int]) -> int:
        start=0
        end=len(nums)-1
        if nums[start] <=nums[end]:
            return nums[start]
        if nums[end]<nums[end-1]:
            return nums[end]
        while start<end:
            mid=start+(end-start)//2
            if nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:
                return nums[mid+1]
            if nums[mid]<nums[start]:
                end=mid-1
            else:
                start=mid+1
            if start==end:
                return nums[start+1]