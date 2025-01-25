"""
Find peak element

BS Approach -
Note - for boundary conditions, we consider -inf to be on the left and right of the array
TC - O(log n)
SC - O(1)
"""

nums = [1, 2, 1, 3, 5, 6, 4]

# nums = [2, 1]

class Solution:
    def findPeakElement(self, nums):
        if nums is None or len(nums) == 0: return -1

        n = len(nums)

        low = 0
        high = n - 1

        while low <= high:
            mid = low + (high - low) // 2

            # check if mid is the peak element
            if (mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1]):
                return mid
            elif nums[mid] < nums[mid + 1]:
                # go to increasing part of the array
                low = mid + 1
            else:
                high = mid - 1
        return -1


obj = Solution()
print(obj.findPeakElement(nums))
