## Problem 3: (https://leetcode.com/problems/find-peak-element/)

#Approach:
# Perform Binary Search on the nums array and find the mid. If value of mid is greater than previous and next element of mid, return mid
# If value of mid < value of mid+1, set low pointer to mid+1 else set high pointer to mid-1
# Continue till the peak element is found at mid.

#Time Complexity: O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = low + (high-low)//2
            if (mid == 0 or nums[mid]> nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
                return mid
            elif nums[mid] < nums[mid+1]:
                low = mid+1
            else:
                high = mid-1
        return -1