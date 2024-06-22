# time: O(log n)
# space: O(1)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l,r = 0, len(nums)-1

        while l<r:
            m = (l+r)//2
            if m==0 and nums[m] > nums[m+1]:
                return m
            elif m==len(nums)-1 and nums[m]>nums[m-1]:
                return m
            elif nums[m] > nums[m+1] and nums[m]>nums[m-1]:
                return m
            
            if nums[m] < nums[m+1]:
                l=m+1
            elif nums[m] < nums[m-1]:
                r=m-1
        
        return l
        