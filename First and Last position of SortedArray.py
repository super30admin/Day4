""""// Time Complexity : O(log(n))
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""




class Solution:
    def searchRange(self, nums, target):
        l = 0
        r = len(nums) - 1
        ans = [-1, -1]
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    ans[0] = mid
                r = mid - 1

            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                    ans[1] = mid
                l = mid + 1
                ans[1] = mid
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return ans


