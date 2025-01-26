# Time Complexity : O(log n)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach in three sentences only

# to find peak check the mid first if it is peak return it
# otherwise go to left if the left element is greater than that
#  or go to the right of it and berform bs and find the peak.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums) 
        low = 0
        high = n - 1
        while low<=high:
            mid = low + (high-low)//2
            # check if mid is peak or not
            if(mid == 0 or nums[mid - 1] < nums[mid]) and (mid == n-1 or nums[mid+1] < nums[mid]): 
                return mid
            
            elif mid > 0 and nums[mid-1] > nums[mid]: #if peak if on left go left by high = mid - 1
                high = mid - 1
            else: # else go right
                low = mid + 1 
        