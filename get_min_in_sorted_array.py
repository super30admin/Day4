class Solution:
    def findMin(self, nums: List[int]) -> int:

        low, high = 0, len(nums) - 1

        while (low <= high):
            # completely sorted array

            mid = low + (high - low) // 2
            if nums[mid] < nums[mid - 1]:
                return nums[mid]
            if nums[low] <= nums[mid] and nums[mid] <= nums[high]:
                return nums[low]

            # if low == mid :

            # return nums[low] if nums[low] < nums[mid] else nums[mid]
            # left sorted meaning min on right array

            if nums[mid] >= nums[low]:
                low = mid + 1

            else:
                high = mid - 1




