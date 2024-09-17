# Time Complexity : O(log(n)) as we are using binary search
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def findPeakElement(self, nums) :
        if len(nums)==0 and nums is None: # checking if list is empty
            return -1
        if len(nums) == 1: # checking if it has a single element
            return 0
        if nums[-1]>nums[-2]: # checking if last element is greater than previous
            return len(nums)-1
        low =0
        high = len(nums)-1
        # Binary Search
        while low <=high:
            mid = low + ((high-low)//2)
            if nums[mid]>nums[mid-1] and nums[mid]>nums[mid+1]:  # checking if mid is peak element
                return mid # peak element found
            elif nums[mid-1]>nums[mid]:
                high = mid-1
            else:
                low = mid+1
        return -1 # no element found 
