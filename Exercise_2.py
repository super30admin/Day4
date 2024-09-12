# 153. Find Minimum in Rotated Sorted Array
# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

# Time Complexity = O(log n)
# Space Complexity = O(1)

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if (len(nums) == 1):
            return nums[0]
        start = 0
        end = len(nums) -1
        
        if nums[0] < nums[end]:
                return nums[start]
        while(start<=end):
            
            mid = start+ (end-start) //2
            
            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
            if nums[mid -1]>nums[mid+1]:
                return nums[mid]
            if (nums[mid] > nums[0]):
                start = mid + 1;
            else:
                end = mid - 1;
        return -1
            