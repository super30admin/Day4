
'''
    Time Complexity:
        O(log(n))

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        -> Find first occurence using Binary Search
        -> If first occurence != -1, find last occurence using Binary Search.
'''
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        fnl = [-1, -1]

        if len(nums) == 0:
            return fnl

        fnl[0] = self.find_first(nums, target)
        if fnl[0] != -1:
            fnl[1] = self.find_last(nums, target)

        return fnl

    def find_first(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if target == nums[mid]:
                if mid == 0 or nums[mid] > nums[mid - 1]:
                    return mid
                high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1

    def find_last(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if target == nums[mid]:
                if mid == len(nums) - 1 or nums[mid] < nums[mid + 1]:
                    return mid
                low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1

        return -1
