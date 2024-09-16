class Solution:
    def findPeakElement(self, nums):
        n = len(nums)
        low = 0
        high = n - 1

        if n == 1:
            return 0

        while low <= high:
            mid = low + (high - low) // 2

            if mid > 0 and mid < n - 1:
                if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                    return mid
                elif nums[mid + 1] > nums[mid]:
                    low = mid + 1
                else:
                    high = mid - 1

            elif mid == 0:
                if nums[0] > nums[1]:
                    return 0
                else:
                    return 1
            elif mid == n - 1:
                if nums[n - 1] > nums[n - 2]:
                    return n - 1
                else:
                    return n - 2