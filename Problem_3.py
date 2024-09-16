# Time Complexity :O(Log(n))
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # no or emptyarray edge case
        if not nums or len(nums) ==0:
            return -1
        low = 0
        high = len(nums)-1
        while low <=high:
            # this is for edge casses where the first or last elemet are peaks and one element in array
            if low == high:
                return low
            mid = low + (high-low)//2
            # if not in edges and the two beside mid are smaller than it return mid
            if mid != 0 and mid != len(nums)-1 and nums[mid-1] < nums[mid] and nums[mid+1] < nums[mid]:
                return mid
            # if the one after it is bigger search right part
            elif nums[mid] < nums[mid+1]:
                low = mid+1
            # else search left part
            else:
                high = mid
        