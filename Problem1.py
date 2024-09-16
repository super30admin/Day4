class Solution:
    def searchRange(self, nums, target):
        result = []

        res1 = -1
        res2 = -1

        l = 0
        r = len(nums) - 1

        # Finding the first index
        while l <= r:
            mid = l + (r - l) // 2

            if nums[mid] == target:
                res1 = mid
                r = mid - 1

            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1

        result.append(res1)

        # Finding the second index
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2

            if nums[mid] == target:
                res2 = mid
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            else:
                l = mid + 1
        result.append(res2)

        return result