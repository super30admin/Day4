# Time Complexity: O(logn)
# Space Complexity: O(1)

# In this problem, we use the concept that to find the peak element, we proceed towards the side of the increasing elements

# This is because, if we proceed towards the increasing slope, we are sure that the slope will fall eventually or we will reach the first/last element, which will be the peak.


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] > nums[mid - 1]) and (
                mid == len(nums) - 1 or nums[mid] > nums[mid + 1]
            ):
                return mid
            elif mid > 0 and nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1
