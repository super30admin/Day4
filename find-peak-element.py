class Solution:
    def findPeakElement(self, nums) -> int:
        z = len(nums)

        if z == 1 or nums[0] > nums[1]:
            return 0
        if nums[-2] < nums[-1]:
            return z - 1
        for i in range(1, z - 1):
            if nums[i - 1] < nums[i] > nums[i + 1]:
                return i

