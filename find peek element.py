#// Time Complexity : O(log(N)) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no because i saw the class video and then did the problem.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n=len(nums)
        if len(nums)==1:
            return 0

        if nums[0]>nums[1]:
            return 0
        if nums[n-1]>nums[n-2]:
            return n-1
        low=1
        high=len(nums)-2
        while low <=high:
            mid=(low+high)//2
            if nums[mid-1]<nums[mid] and nums[mid+1]<nums[mid]:
                return mid
            elif nums[mid-1]>nums[mid]:
                high=mid-1
            else:
                low=mid+1

# Approach:
# The problem can be solved using a binary search approach. We start by checking if the first element is
# greater than the second element. If it is, then the first element is the peak element. If
# the last element is greater than the second last element, then the last element is the peak element.
# If neither of the above conditions are met, then we perform a binary search on the array. We
# keep dividing the array in half until we find the peak element.