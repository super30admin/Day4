from typing import List
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int] :
        result1 = self.firstOccurence(nums, target)
        if result1 == -1:
            return [-1, -1]
        else:
            result2 = self.lastOccurence(nums, target, result1)
            return [result1, result2]
    
    def firstOccurence(self, nums: List[int], target: int):
        start = 0
        end = len(nums)-1
        while start<=end:
            mid = start+(end-start)//2                 
            if nums[mid]==target:
                if mid == 0 or nums[mid]>nums[mid-1]:
                    return mid
                else:
                    end = mid-1                
            elif nums[mid]< target:
                start = mid+1
            else:
                end = mid-1
        return -1
    
    def lastOccurence(self, nums: List[int], target: int, result1: int):
        start = result1
        end = len(nums)-1
        while start<=end:
            mid = start+(end-start)//2
            if nums[mid]==target:
                if mid == len(nums)-1 or nums[mid]<nums[mid+1]:
                    return mid
                else:
                    start = mid+1
            elif nums[mid]>target:
                end = mid-1
            else:
                start = mid+1                
        return -1

# sol = Solution()
# print(sol.searchRange([1,2,2,2,3,4,5,6], 2))

""" This implementation uses two binary searches 
one search to find the first occurence of the target 
and the other to find the last occurence
and each takes O(log(n)) complexity."""
        