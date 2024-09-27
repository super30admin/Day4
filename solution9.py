#Time Complexity=O(log n)
#Space Complexity=O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        m=5000
        low=0
        high=len(nums)-1
        while(low<=high):
            mid= low+(high-low)//2
            if(nums[mid]<nums[high]):
                high=mid-1
            else:
                low=mid+1
            if nums[mid]<m:
                m=nums[mid]
        return m