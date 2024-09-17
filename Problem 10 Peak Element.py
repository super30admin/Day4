# Time Complexity: O(log(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Logic: Run binary search until start = end & compare mid with neighbours. If mid + 1 is greater than we are at falling
# slope & peak would be towards left else we are on rising slope, move right until start = end. At this point start will
# be pointing towards peak element.

class Solution:
    def findPeakElement(self, nums):
        start = 0
        end = len(nums)
        while start < end:
            mid = start + (end-start)//2
            if nums[mid] > nums[mid+1]:
                end = mid
            else:
                start = mid + 1
        return start
