# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return -1

        low = 0
        high = len(nums) - 1

        while low <= high:
            # If the portion is sorted, return the first element
            if nums[low] <= nums[high]:
                return nums[low]

            mid = low + (high - low) // 2

            # If mid element satisfies the min conditions, return it
            if (mid == low or nums[mid] < nums[mid - 1]) and (mid == high or nums[mid] < nums[mid + 1]):
                return nums[mid]

            # Else, move towards the unsorted portion of the array
            elif nums[low] <= nums[mid]:
                low = mid + 1

            else:
                high = mid - 1

        return -1