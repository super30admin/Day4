# Time Complexity: O(logn)
# Space Complexity: O(1)

# In this problem, we use the concept that in a rotated sorted array, the pivot element will be smaller than both neighbors

# Also, in a sorted array, the minimum element will be the first element, or the low pointer element

# In this binary search, we reject half of the elements, based on rejecting the sorted side. The Pivot element will lie on the unsorted side


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (
                mid == len(nums) - 1 or nums[mid] < nums[mid + 1]
            ):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
