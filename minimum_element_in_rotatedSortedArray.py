# Time Complexity : O(log(n))
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Used binary search inorder to find the minimum element in the rotated sorted array.


class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        elif nums[0]<=nums[len(nums)-1]:
            return nums[0]
        
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid]>=nums[low]:
                if mid == high or nums[mid]>nums[mid+1]:
                    return nums[mid+1]
                else:
                    low = mid+1
            elif nums[mid]<=nums[high]:
                if mid == low or nums[mid]<nums[mid-1]:
                    return nums[mid]
                else:
                    high = mid-1
                    


Simplified Solution:

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        elif nums[0]<=nums[len(nums)-1]:
            return nums[0]
        
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
            
            if nums[mid]<nums[mid-1]:
                return nums[mid]
            
            if nums[mid]>=nums[low]:
                low = mid+1
            else:
                high = mid-1