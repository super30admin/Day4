// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :found difficulty in determinig edge conditions.
// Your code here along with comments explaining your approach
// I have followed the optimal approach discussed in the class.
class Solution:
    def findMin(self, nums: List[int]) -> int:
        min_value = inf
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            mid = (lo + hi) // 2
            min_value = min(min_value, nums[mid])
            if nums[mid] < nums[hi]:
                hi = mid - 1
            else:
                lo = mid + 1
        return min_value