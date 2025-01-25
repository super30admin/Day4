'''
Time Complexity :
log(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        def findFirst(nums, target):
            left, right = 0, len(nums) - 1
            first_pos = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    first_pos = mid
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return first_pos

        def findLast(nums, target):
            left, right = 0, len(nums) - 1
            last_pos = -1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    last_pos = mid
                    left = mid + 1
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid - 1
            return last_pos

        # Find the first and last positions
        first = findFirst(nums, target)
        last = findLast(nums, target)
        return [first, last]
