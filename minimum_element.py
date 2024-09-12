## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: we use binary search method to reduce the time complexity of traversing an entire array. Since array is rotated, we have to find the increasing subsequence of the array to find the minimum element . 
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1
        while(low<=high):
            if(nums[low]==nums[high]):
                return nums[low]
            mid=low+(high-low)//2
            print(mid)
            if(mid==0 or nums[mid]<nums[mid-1]) and nums[mid]<nums[mid+1]:
                return nums[mid]
            else:
                if nums[mid]>nums[high]:
                    low=mid+1
                else:
                    high=mid-1
        return nums[low]
        
