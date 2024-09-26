#Time Complexity: O(log n)
#Space Complexity: O(1)

class Solution:
    def findMin(self, nums) -> int:
        left=0
        right=len(nums)-1
        while left<right:
            if nums[left]<=nums[right]:
                break
            mid=(left+right)//2
            if nums[right]<nums[mid]:
                left=mid+1
            else:
                right=mid
        return nums[left]
        