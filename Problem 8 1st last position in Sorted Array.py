# Time Complexity: O(log(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Logic: Binary search algorithm will be called twice, one to find the 1st occurrence & 2nd time for last one.

class Solution:
    def searchRange(self, nums, target):
        start_index = self._find_index(nums, target, True)
        if start_index == -1:
            return [-1, -1]
        else:
            end_index = self._find_index(nums, target, False)
        return [start_index, end_index]

    def _find_index(self, nums, target, isFirst):
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = start + (end - start)//2
            if nums[mid] == target and isFirst:
                if mid == start or nums[mid-1] != target:
                    return mid
                else:
                    end = mid - 1
            elif nums[mid] == target and not isFirst:
                if mid == end or nums[mid + 1] != target:
                    return mid
                else:
                    start = mid + 1
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1
        return -1
