# // Time Complexity : O(log(n))
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Binary search
# min will always fall on unsorted side
# go to unsortedf side
# check for mid < mid-1 and mid < mid+1
# also if the low and high is already sorted return low

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1
        
        while left <= right:
            
            mid = (right + left)//2
            
            if nums[left] < nums[right]:
                return nums[left]
            
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid] < nums[mid+1]):
                return nums[mid]
            
            if nums[mid] < nums[right]:
                right = mid-1
            else:
                left = mid+1
        
        return -1