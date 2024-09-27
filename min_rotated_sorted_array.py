#Time Complexity = O(logn)
#Space Complexity = O(1)
#Successfully compiled and run in Leetcode

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l = 0
        r = len(nums) - 1

        while l < r:
            m = l + (r - l) // 2

            if nums[m] > nums[r]: # if mid val is greater than last val - then its rotated array
                l = m + 1 # we search in right portion

            elif nums[m] < nums[r]: #else we go to left portion
                r = m

            else:
                return nums[r] # return last val

        return nums[l] #return min val