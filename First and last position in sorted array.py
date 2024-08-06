#// Time Complexity : O(log(N)) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        first=-1
        low=0
        high=len(nums)-1
        last=-1

        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target:
                first=mid
                high=mid-1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        low=0
        high=len(nums)-1
        last=-1
        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target:
                last=mid
                low=mid+1
            elif nums[mid]<target:
                low=mid+1
            else:
                high=mid-1
        return [first,last]
    
# Approach:
# The problem is asking us to find the first and last occurrence of a target number in a sorted array
# We can use a modified binary search algorithm to solve this problem. The idea is to find the first
# and last occurrence of the target number by adjusting the search space in each iteration.