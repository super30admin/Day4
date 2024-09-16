'''
    Time Complexity:
        O(log(n))

    Space Complexity:
        O(n)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        -> If mid is greater than left and right, it's the peak.
        -> Else move the pointer towards the side of the greater element,
            because it's sure to find one of the peaks on that side.
'''
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if (mid == 0 or nums[mid] > nums[mid - 1]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
                return mid

            if mid > 0 and nums[mid] < nums[mid - 1]:
                high = mid - 1
            else:
                low = mid + 1

        return -1
