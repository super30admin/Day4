# // Time Complexity : O(logn) as it is using binary search.
# // Space Complexity : O(1) constant time as it is not using any auxilary memory.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# In this problem to find the peak element we see whether it is greater than its neighbouring elements and if is we return that element.If the element not found we just return -1.




class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return -1
        low=0
        high=len(nums)-1
        while low<=high:
            mid=int(low+((high-low)/2))
            if (mid==len(nums)-1 or nums[mid]>nums[mid+1]) and (mid==0 or nums[mid]>nums[mid-1]):
                return mid
            elif nums[mid+1]>nums[mid]:
                low=mid+1
            else:
                high=mid-1
        return -1
                
        