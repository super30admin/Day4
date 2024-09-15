# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            # If mid element satisfies the peak conditions, return its index
            if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid

            # Else, move towards the increasing side of the array
            elif mid > low and nums[mid] < nums[mid - 1]:
                high = mid - 1

            else:
                low = mid + 1

        return -1
