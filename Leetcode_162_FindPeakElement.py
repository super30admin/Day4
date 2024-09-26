#Time complexity: O(log n)
#Space Complexity: O(1)

class Solution:
    def findPeakElement(self, nums) -> int:
        left, right=0,len(nums)-1
        while left<right-1:
            mid=(left+right)//2
            if nums[mid]>=nums[mid+1] and nums[mid]>=nums[mid-1]:
                return mid
            if nums[mid+1]>nums[mid]:
                left=mid+1
            else:
                right=mid-1
        if nums[left]>=nums[right]:
            return left
        return right