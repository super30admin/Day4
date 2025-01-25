"""
Find First and Last Position of Element in Sorted Array

Brute force - Linear search - TC - O(n)

Optimized BS Approach -
Perform BS on left
Perform BS on right
TC - O( log n)
SC - 0(1)
"""

nums = [5, 7, 7, 8, 8, 10]
target = 8
# nums = [2, 1]


class FirstLastIdx:
    def searchRange(self, nums, target):
        # Base case
        if nums is None or target is None: return -1

        def searchLeft(nums, target):
            low = 0
            high = len(nums) - 1
            idx = -1
            while low <= high:
                mid = low + (high - low) // 2

                if nums[mid] == target:
                    idx = mid

                if nums[mid] >= target:
                    # search in left
                    high = mid - 1
                else:
                    low = mid + 1
            return idx

        def searchRight(nums, target):
            low = 0
            high = len(nums) - 1
            idx = -1
            while low <= high:
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    idx = mid
                if nums[mid] <= target:
                    low = mid + 1
                else:
                    high = mid - 1
            return idx

        rtnData = [-1, -1]
        rtnData[0] = searchLeft(nums, target)
        rtnData[1] = searchRight(nums, target)

        return rtnData


obj = FirstLastIdx()
print(obj.searchRange(nums, target))
