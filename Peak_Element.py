class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        peak=self.binary_search_peak(nums)
        
        return peak
        
        
    def binary_search_peak(self,nums):
        low=0
        high=len(nums)-1

        while low<=high:
            mid=low+(high-low)//2

            if (mid==0 or nums[mid-1]<nums[mid]) and (mid==len(nums)-1 or nums[mid+1]<nums[mid]):
                return mid

            elif nums[mid-1]>nums[mid+1]:
                high=mid-1
            else:
                low=mid+1
                