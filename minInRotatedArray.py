class Solution:
    def findMin(self, nums: List[int]) -> int:     
        low, high = -1, len(nums)-1

        while low+1<high:
            mid = (low+high)//2

            if nums[mid]<= nums[-1]:
                high = mid
            else:
                low = mid
        return nums[high]    
