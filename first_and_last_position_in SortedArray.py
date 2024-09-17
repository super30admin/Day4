# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Used binary search inorder to find the search range value in array
#Using 2 functions separately for left position and right position.

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1,-1]
        
        low = 0
        high = len(nums)-1
        if nums[0] == target and nums[high] == target:
            return [low,high]
        
        def binarySearchLeft(low,high,target,nums):
            while low<=high:
                mid = low+(high-low)//2
                if nums[mid] == target:
                    if mid == low or nums[mid-1]<nums[mid]:
                        return mid
                    else:
                        high = mid-1
                elif nums[mid]>target:
                    high = mid-1
                else:
                    low = mid+1
            return -1
        
        def binarySearchRight(low,high,target,nums):
            while low<=high:
                mid = low + (high-low)//2
                if nums[mid] == target:
                    if mid == high or nums[mid+1]>nums[mid]:
                        return mid
                    else:
                        low = mid+1
                elif nums[mid]>target:
                    high = mid-1
                else:
                    low = mid+1
            return -1
        
        
        left = binarySearchLeft(low,high,target,nums)
        right = binarySearchRight(low,high,target,nums)
        
        return [left,right]