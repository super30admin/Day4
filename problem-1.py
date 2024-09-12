# Time-Complexity: O(log(n))
# Space-Complexity: O(1)
# Solved in leetcode: yes
# Problem? : No

import bisect
class Solution:
    def searchRange(self, nums, target: int):
        if len(nums) == 0: return [-1,-1]
        f = bisect.bisect_left(nums,target,lo=0,hi=len(nums)-1)
        l = bisect.bisect_right(nums,target,lo=0,hi=len(nums))
        if nums[f] == target and nums[l-1] == target:

            return [f,l-1]
        else:
            return [-1,-1]

obj = Solution()
print(obj.searchRange([5,7,7,8,8,10],8))