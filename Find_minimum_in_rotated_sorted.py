# Time complexity: O(logn)
# Space complexit: O(1)
# Does this code run on Leetcode: Yes
# Problems faced while coding the solution: None

class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        l, r = 0, len(nums) - 1

        while l <= r:
            # case if the array is already sorted.
            if nums[l] < nums[r]:
                res = min(res, nums[l])
                break
            m = (l + r) // 2
            res = min(res, nums[m])
            # we will shift the left pointer to the right of the mid if the value at mid is greater than the value
            # at the left pointer.
            if nums[m] >= nums[l]:
                l = m + 1
            # else, we will shift the right pointer to the left of the mid value.
            else:
                r = m - 1
        return res