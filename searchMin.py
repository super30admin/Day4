# Leetcode 153. Find Minimum in Rotated Sorted Array

# Time Complexity :  O(log n) where n is the size of the array

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Condition: If both the neighbours are greater than the current then its the min.
# When the array is split at the mid atleast one side is unsorted and the target is on the unsorted side.
# If the left side is sorted then search on right side and vice versa

# Your code here along with comments explaining your approach

class Solution:

    def minSearch(self, nums, low, high) -> int:
        while low <= high:
            mid = low + ((high-low)//2)

            # if mid points to the 0th index or the element BEFORE mid is greater than mid
            # and if mid points to the last index or the element AFTER mid is greater than mid
            if ((mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid+1] > nums[mid])):
                return nums[mid]
            # Check if the array is sorted if yes then move to the other side
            if nums[mid] < nums[high]:
                high = mid - 1
            else:
                low = mid+1
        return -1

    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        return self.minSearch(nums, low, high)
