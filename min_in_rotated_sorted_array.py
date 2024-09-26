# Time Complexity: O(log(n))
# Space Complexity: O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[low]<=nums[high]: return nums[low]
            if (mid==0 or nums[mid]<nums[mid]-1) and (mid==len(nums)-1 or nums[mid]<nums[mid+1]): return mid
            if nums[low]<=nums[mid]:
                low=mid+1
            else:
                high=high-1
        return -1
        