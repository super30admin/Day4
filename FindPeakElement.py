// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 0
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if (mid==0 or nums[mid-1]<nums[mid]) and (mid==len(nums)-1 or nums[mid+1]<nums[mid]): # checking for before and prev
                                                                                                # element to find a peak.
                return mid
            elif nums[mid]<nums[mid+1]: # if element to right is greater, more chance of getting to the peak.
                low=mid+1
            else:
                high=mid-1
        return -1