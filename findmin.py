#Time complexity:O(log n)
#Space complexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[low]<=nums[high]:
                return nums[low]
            elif (mid==0 or nums[mid]<nums[mid-1]) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                return nums[mid]
            elif nums[mid]<nums[high] and nums[mid]<nums[mid+1]:
                high=mid-1
            else:
                low=mid+1
            