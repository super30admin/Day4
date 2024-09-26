"""
Time Complexity:    O(log(n))
Space Complexity:   O(1)
YES, The code successfully ran on Leetcode

Approach - My approach is pretty straight forward, I am using binary search to search the min value,
every divide of array we have to find where must  the min lie, for that we take advantage of the sorted array
and pivot. we look if the value at left from mid is strictly lower if it is then we go right and vice versa.
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return -1
        low = 0
        high = len(nums) - 1
        if nums[low] <= nums[high]:
            return nums[low]
        while low <= high:
            mid = low + (high - low) // 2
            if nums[low] <= nums[high]:
                return nums[low]
            if (mid == 0 or nums[mid - 1] > nums[mid]) and (mid == len(nums) - 1 or nums[mid + 1] > nums[mid]):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1