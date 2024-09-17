# Time complexity: O(log(n))
# Space Complexity: O(1)
# Approach: Using divide and conquer -> binary search, if nums[low] < nums[high], means it is the minimum (we found rotated sorted array), return it.
# If mid == low or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid+1], means we found the point from where array is rotated, nums[mid] is minimum
# so return it. elseif nums[low] <= nums[mid], we should search other sublist (low = mid + 1), else high = mid - 1.
# finally no minimum? return -1

class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums) - 1
        while (low <= high):
            mid = low + (high - low) // 2
            if nums[low] < nums[high]:
                return nums[low]
            if (mid == low or nums[mid] < nums[mid-1]) and (mid == high or nums[mid] < nums[mid+1]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1