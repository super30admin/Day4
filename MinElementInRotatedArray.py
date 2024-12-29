# Time compliexity: O(log n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes
# No issues faced

# Approach Description:
# when working on rorated arrays, we observed that either of the two halves will be sorted
# on further observation we saw that the min element is always on the unsorted side
# if the list contains 1 element, we return that element
# if the full list is sorted, then we will return the first elemet
# next, we check if left side is sorted, if so, we move to the right side
# if not, we stay on the left side
# then we perform binary search based on the check if the mid element is smaller than both it's adjacent elements


class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        # atleast one side of the rotated array will be sorted
        # and the min element will lie on the unsorted side

        low = 0
        high = len(nums) - 1

        if len(nums) == 1:
            return nums[0]

        while (low <= high):
            # if full list is sorted, return the min element
            if nums[low] <= nums[high]:
                return nums[low]

            # computing middle
            mid = low + (high - low) / 2

            # if mid is smaller than the left and right element both
            # handling edge case - when mid is either low or high
            # then mid is smallest
            if ((mid == 0 or nums[mid - 1] > nums[mid]) and (mid == len(nums) -1 or nums[mid + 1] > nums[mid])):
                # nums[mid] is the smallest
                return nums[mid]
            
            # else will start by checking if the left side is sorted
            if nums[low] <= nums[mid]:
                # left side is sorted
                # so we will move to right side
                low = mid + 1
            else:
                # left is unsorted
                high = mid - 1
        
        return -1