# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Binary search is used
# we checked for mid > mid+1 and mid > mid-1
# if found we return mid
# if not we go towards higher element  

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1

        
        while left <= right:
            mid = (left + right)//2
            
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            
            elif nums[mid+1] > nums[mid]:
                left = mid+1
            
            else:
                right = mid-1
        
        return -1