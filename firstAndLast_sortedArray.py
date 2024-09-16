# Time Complexity : O(log N) where N is length of array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
class Solution:
    def searchRange(self, nums: [int], target: int):
        # edge case
        if not nums or len(nums) == 0:
            return [-1, -1]

        low = 0
        high = len(nums)
        result = [-1, -1]
        while low < high:
            mid = low + (high - low) // 2
            if nums[mid] == target:  # if target is in the mid
                high = mid
                result[0] = mid
                result[1] = mid
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid
        if result[0] == -1:
            return result
        low = result[0] + 1
        high = len(nums)
        while low < high:
            mid = int(low + (high - low) // 2)
            if nums[mid] == target:
                low = mid + 1
                result[1] = mid
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid
        return result


r = Solution()
nums = [5, 7, 7, 8, 8, 10]
target = 8
print("Target start and end indices are:", r.searchRange(nums, target))
