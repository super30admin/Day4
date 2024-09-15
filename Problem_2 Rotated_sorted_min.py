# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while (low < high):
            mid = low + (high - low) // 2
            if nums[mid] < nums[high]:
                high = mid
            else:
                low = mid + 1
        return nums[low]