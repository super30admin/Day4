# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        self.pos = [-1, -1]
        low = 0
        high = len(nums) - 1
        self.binary_search(low, high, nums, target, True)
        self.binary_search(low, high, nums, target, False)
        return self.pos

    def binary_search(self, low, high, nums, target, isleft):
        while (low <= high):
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if (isleft):
                    self.pos[0] = mid
                    high = mid - 1
                else:
                    self.pos[1] = mid
                    low = mid + 1

            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return



