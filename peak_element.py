#Time Complexity = O(logn)
#Space Complexity = O(1)
#Successfully compiled and run on Leetcode

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = 0
        h = len(nums) - 1

        while l < h:
            mid = l + (h - l) // 2

            if nums[mid] > nums[mid + 1]: # initially checking if mid val is greater than its next element
                h = mid # search in right portion - logic is to move towards incrementing tendency
            else:
                l = mid + 1 # else search in left portion

        return l # returning pivot element


