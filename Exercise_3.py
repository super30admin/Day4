# 162. Find Peak Element
# https://leetcode.com/problems/find-peak-element/

# Time Complexity = O(log n)
# Space Complexity = O(1)


class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start = 0
        end = len(nums) - 1
        
        if len(nums) ==1:
            return 0
        
        while start<= end:
            mid = start + (end - start) / 2
            if ((mid == (len(nums) -1) or nums[mid] > nums[mid+1] ) and (mid == 0 or nums[mid] > nums[mid-1])):
                return mid
            elif mid != 0 and nums[mid -1]> nums[mid]:
                end = mid-1
            else:
                start = mid +1
        return -1