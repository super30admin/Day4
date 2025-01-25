"""
Find Minimum in Rotated Sorted Array

Brute force approach -> Linear search (TC - O(n) OR sort the array and return 0th index element (TC - O(n log n))

Optimized BS approach:
TC - O(log n)
SC - O(1)
"""

nums = [4, 5, 6, 7, 0, 1, 2]

# nums = [2, 1]

class Solution:
    def findMin(self, nums):
        # Base case
        if nums is None or len(nums) == 0: return -1

        n = len(nums)

        low = 0
        high = n - 1

        while low < high:
            # check if array is already sorted
            if nums[low] < nums[high]: return nums[low]

            mid = low + (high - low) // 2

            # check boundary condition and check if mid is the min
            if (mid == 0 or nums[mid] < nums[mid - 1]) and (nums[mid] < nums[mid + 1]):
                return nums[mid]
            elif nums[mid] < nums[high]:
                # search in left
                high = mid - 1
            else:
                low = mid + 1
        return nums[low]


obj = Solution()
print(obj.findMin(nums))
