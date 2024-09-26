# Time Complexity : O(logn) since we are using binary search
# Space Complexity : No auxiliary space needed. O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        
        # if len(nums)==1:
        #     return 0
        # Need not give the length = 1 edge case as the binary search below works fine for that case as well
        
        while(low<=high):
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid]>nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                # Check if mid element is peak, also check for cases when mid is first or last element
                return mid # Return mid if the element is a peak
            elif nums[mid+1]>nums[mid]:
                low = mid+1 # If mid+1 element is higher, move search to the right half
            else:
                high = mid-1 #If mid-1 element is higher, move search to left half