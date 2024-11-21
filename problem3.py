#Time complexity is O(log n) and space complexity is O(1)
#was able to run on leetcode
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        s=0
        e=len(nums)-1
        if len(nums)==1:
            return 0
        
#Binary Search
        while s<=e:
            m=s+(e-s)//2
# Edge cases
            if m == 0 and nums[m+1]<nums[m]:
                return m
            if m==len(nums)-1 and nums[m-1]<nums[m]:
                return m     
            
            if nums[m-1]<nums[m] and nums[m]>nums[m+1]:
                return m
            if nums[m]<nums[m+1]:
                s=m+1
            else:
                e=m-1
