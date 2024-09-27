# time complexity
O(log N)

# Space complexity 

O (1)

#  code worked on leetcode




class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or nums is None:
            return -1
        low,high = 0,len(nums)-1
        while low<= high:
            mid = low+(high-low)/2
            if (mid ==0 or nums[mid]> nums[mid-1]) and (mid == len(nums)-1 or nums[mid]>nums[mid+1]):
                return mid
            elif mid!=0 and nums[mid]<nums[mid-1]:
                high = mid-1
            else:
                low = mid+1
