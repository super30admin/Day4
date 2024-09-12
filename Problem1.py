# Find First and Last Position of Element in Sorted Array
''' Time complexity : O(log N)
Space Complexity: O(1)


Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no '''

class Solution:
    
    def binarySearchFirst(self,nums: List[int],target: int):
        low=0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if target==nums[mid]:
                if (mid ==0 or nums[mid-1]<nums[mid]):
                    return mid
                elif nums[mid-1]==nums[mid]:
                    high = mid-1
            elif target > nums[mid]:
                low = mid +1
            else:
                high = mid-1
        return -1
    
    def binarySearchLast(self,nums: List[int],target: int):
        low=0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if target==nums[mid]:
                if (mid ==len(nums)-1 or nums[mid+1]>nums[mid]):
                    return mid
                elif nums[mid+1]==nums[mid]:
                    low = mid+1
            elif target > nums[mid]:
                low = mid +1
            else:
                high = mid-1
        return -1
    
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums)==0:
            return[-1,-1]
        if (target<nums[0] or target>nums[len(nums)-1]):
            return[-1,-1]
        first = self.binarySearchFirst(nums,target)
        second = self.binarySearchLast(nums,target)
        return [first,second]
