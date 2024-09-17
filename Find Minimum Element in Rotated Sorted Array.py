# Space Complexity : O(1)
# Time Complexity : O(log N)
# Did this code successfully run on Leetcode : Y
# Any problem you faced while coding this : N


# Your code here along with comments explaining your approach


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        # check if end element of array is greater than first element,
        # if thats the case, there's no rotation return first element

        if high == 0 or nums[0] < nums[high]: return nums[0]

        # find pivot point of rotated array, point where the maximum element resides.
        # The next point would be where the minimum element is present

        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] > nums[low]:
                low = mid
            else:
                high = mid
        return nums[low + 1]

