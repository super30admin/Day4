# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes
# I first checked  "if nums[end] < nums[mid]:" as "nums[end] < nums[start]" which led to mistakes in
# situations where the minimum element is in the first half of rotated sorted array.
# Then resolved it while working it out on paper.

class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        start = 0
        end = len(nums) - 1

        if start == end:
            return nums[start]

        while(start <= end):
            mid = start + (end-start)//2
            #  if nums[mid] > nums[mid+1] then pivot starts at mid + 1
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            # if nums[mid-1] > nums[mid] then pivot starts at mid
            elif nums[mid-1] > nums[mid]:
                return nums[mid]
            # if nums[end] < nums[mid] then first half is sorted and second half has the min/pivot
            if nums[end] < nums[mid]:
                start = mid + 1
            # if nums[end] > nums[mid] then second half is sorted and first half has the min/pivot
            else:
                end = mid - 1
