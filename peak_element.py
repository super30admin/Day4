"""
TC:O(n)
SC:O(1)
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1 or len(nums)==0:
            return 0
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = int(ceil((low+high)/2))
            if mid == 0:
                if nums[mid+1]<nums[mid]:
                    return mid
            elif mid == len(nums)-1:
                if nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high = mid-1
            else:
                if nums[mid]>nums[mid+1] and nums[mid]>nums[mid-1]:
                    return mid
                elif nums[mid+1]>nums[mid]:
                    low = mid+1
                else:
                    high = mid-1
        return 0