# Time Complexity : Ologn
# we find peak by checking neghbours of midpoint
# when loop exits, that will be when l = r which is the last element ie. a peak

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:

        l, r = 0, len(nums) - 1

        while l < r:
            mid = l + (r - l) // 2

            if mid > 0 and nums[mid] < nums[mid - 1]:  # Check if left neighbor is greater
                r = mid - 1
            elif mid < len(nums) - 1 and nums[mid] < nums[mid + 1]:  # Check if right neighbor is greater
                l = mid + 1
            else:
                return mid

        return l
