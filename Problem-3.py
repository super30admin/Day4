
# Approach
# Get peek of an array rules: can be multiple peeks
#if mid-1<mid>mid+1 that is the peek element else: if mid-1>mid>mid+1 move right else move left

# Complexities
# Time Complexity: O(log n)
# space Complexity : O(1) + O( log n) recursive stack space

from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        return self.binarySearch(nums, 0, len(nums) - 1)

    def binarySearch(self, nums, low, high):
        if (high - low) > 0:
            mid = int((low + high) / 2)

            if nums[mid-1] <= nums[mid] > nums[mid+1]:
                return mid
            else:
                if mid == low:
                    return high

                if nums[mid - 1] <= nums[mid] <= nums[mid + 1]:
                    return self.binarySearch(nums, mid + 1, high)
                else:
                    return self.binarySearch(nums, low, mid - 1)

        else:
            return low

s = Solution()
print(s.findPeakElement([1]))