# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        elif len(nums) == 2:
            if nums[0] > nums[1]:
                return nums[1]
            return nums[0]
        a = self.conversionPoint(nums,0,len(nums)-1)
        print(a)
        if a == -1:
            return nums[0]
        return nums[a]
    def conversionPoint(self,nums,l,r):
        if l == r-1:
            return r
        mid = (l + r) //2
        if nums[mid] < nums[l]:
            return self.conversionPoint(nums,l,mid)
        elif nums[mid] > nums[r]:
            return self.conversionPoint(nums,mid,r)
        else:
            return -1