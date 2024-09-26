# Time Complexity : O(logn)
# 
# Space Complexity : O(1)
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No
#
# Problem Approach
# 1. Perform seperate binary search to get the first and last index of the target
# 2. Need to take care of the edge cases
#   2.1 While looking for the First position, so the (mid-1) does not exist when mid = 0
#   2.1 Similarly while searching for the last position, the (mid + 1) does not exist when mid = len(nums) - 1 
class Solution:
    def findFirstPosition(self, nums, target):
        start, end = 0, len(nums)-1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] < target: # mid == 0, check index out of bound edge case
                    return mid
                else:
                    end = mid - 1
            elif nums[mid] > target:
                end = mid -1
            else:
                start = mid+1
        return -1
                
    def findLastPosition(self, nums, target):
        start, end = 0, len(nums)-1
        while start <= end:
            mid = start + (end - start) // 2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid+1] > target:# mid == len(nums)-1, check index out of bound edge case
                    return mid
                else:
                    start = mid+1
            elif nums[mid] > target:
                end = mid -1
            else:
                start = mid+1
        return -1
                
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        s_index = self.findFirstPosition(nums, target)
        e_index = self.findLastPosition(nums, target)
        return [s_index, e_index]