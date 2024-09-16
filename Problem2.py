#
# Time Complexity = O(log(n)) 
# Space Complexity = O(1)
# Works on Leetcode https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
#
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums)-1
        res = nums[0]
        while(l <= r):
            mid = l+(r-l)//2
            if nums[l] <= nums[mid]:
                res = min(res, nums[l])
                l = mid+1
            else:
                res = min(res, nums[mid])
                r = mid-1
        return res
