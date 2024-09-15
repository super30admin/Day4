##Time Complexity : O(log(n))
##Space Complexity : O(1)
##Did this code successfully run on Leetcode : Yes
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        l, r = 0, len(nums) - 1
        startIndex, endIndex = -1, -1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:  
                startIndex, endIndex = mid, mid
                while startIndex > l:
                    lMid = (l + startIndex) // 2
                    if nums[lMid] < target:
                        l = lMid + 1
                    else:
                        startIndex = lMid
                while endIndex + 1 <= r:
                    rMid = (r + endIndex + 1) // 2
                    if nums[rMid] > target:
                        r = rMid - 1
                    else:
                        endIndex = rMid
                return [startIndex, endIndex]
        return [startIndex, endIndex]



