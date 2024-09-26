#Time complexity:O(logn)
#sapce complexity: O(1)
class Solution:
    def findMin(self, nums) -> int:
        res=5001
        low,high=0,len(nums)-1
        while low <= high:
            mid = (low+high)//2
            if nums[mid]<= nums[high]:
                res=min(nums[mid],res)
                high=mid-1
            elif nums[mid]>= nums[low]:
                res= min(nums[low],res)
                low=mid+1
        return res
                