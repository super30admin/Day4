# Time Complexity : O(log N) due to binary search, where N is length of array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

class Solution:
    def findPeakElement(self, nums: [int]):
        # edge case
        if not nums or len(nums) == 0:
            return -1
        left_num = 0
        right_num = len(nums) - 1
        while left_num < right_num:
            mid = left_num + (right_num - left_num) // 2
            if nums[mid] > nums[mid + 1]:
                right_num = mid
            else:
                left_num = mid + 1
        return right_num


r = Solution()
nums = [1, 2, 1, 3, 5, 6, 4]
print("Peak element index is:", r.findPeakElement(nums))
