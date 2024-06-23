# Time Complexity: O(logn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# do BS and go towards the higher val side after comparing mid val with mid + 1 and mid - 1 val
class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        low = 0
        high = len(nums) - 1
        if len(nums) == 1:
            return 0
        elif len(nums) == 2:
            if nums[low] >= nums[high]:
                return low
            else:
                return high

        while low < high:
            mid = low + (high - low) // 2
            if mid == low and nums[mid] > nums[mid + 1]:
                return mid
            if mid == high and nums[mid] > nums[mid - 1]:
                return mid
            if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                return mid
            if nums[mid - 1] > nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return low