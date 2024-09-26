"""Initially a few test cases failed but I was able to solve with a little more effort"""

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        ind = 0
        if len(nums)==1:
            return 0
        if nums[0]>nums[1] :
            return 0
        elif nums[len(nums)-1] > nums[len(nums)-2]:
            return len(nums)-1
        while ind + 1 <= len(nums)-1:
            if nums[ind-1]<nums[ind] and nums[ind]>nums[ind+1]:
                return ind
            else:
                ind = ind + 1