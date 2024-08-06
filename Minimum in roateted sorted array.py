#// Time Complexity : O(log(N)) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left=0
        right=len(nums)-1
        res=99999999
        while left<=right:
            mid=(left+right)//2
            if nums[left]<=nums[right]:
                res=min(res,nums[left])
                break
            
            if nums[mid]>=nums[left]:
                res=min(res,nums[left])
                left=mid+1
            else:
                res=min(res,nums[mid])
                right=mid-1
        return res

# Approach:
# The problem is asking us to find the smallest element in a sorted rotated array. We can solve this
# problem by using a binary search approach. We start by initializing two pointers, left and right, to
# the start and end of the array respectively. We then enter a while loop that continues until left is
# less than or equal to right.