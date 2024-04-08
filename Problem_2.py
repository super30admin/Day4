## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

#Approach:
# Smallest element will always be on the unsorted side of the rotated array. Perform binary search on it. If nums[low]<nums[high]: return nums[low] as it will be a sorted array
# Calculate mid. If mid < mid+1 and mid < mid-1: return mid
# if low<mid: then it is a left sorted array; move low = mid +1 else high = mid-1

#Time Complexity: O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while(low<=high):
            if nums[low] <= nums[high]:
                return nums[low]
            mid = low + (high-low)//2
            print(mid)
            if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid-1
        return -1         