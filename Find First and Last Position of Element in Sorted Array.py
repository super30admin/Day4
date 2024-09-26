from typing import List
class Solution:
    def BinarySearch(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid_point=(low+high)//2
            if target<nums[mid_point]:
                high=mid_point-1
            elif target>nums[mid_point]:
                low=mid_point+1
            else:
                return mid_point
        return -1

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        element=self.BinarySearch(nums,target)
        if element == -1:
            return [-1,-1]
        else:
            i=j=element
            while i>=0 and nums[i]==nums[element]:
                i-=1
            i+=1
            while j<len(nums) and nums[j]==nums[element]:
                j+=1
            j-=1
            return [i,j]