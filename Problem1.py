"""
34. Find First and Last Position of Element in Sorted Array
Approach --
1. set high, low elements. Find mid
2. check if mid is equal to target. if yes, check its immediate left and immediate right to see if they are same elements
3. if yes move in either direction to find the first/last position
4. if mid > target, search in the left to find the element. perform binary search
5. if mid < target, search in the right to find the element. perform binary search
Time complexity - O(log n)
Space complexity O(1)
"""


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def searchLeft(nums, target):
            idx = -1
            low = 0
            high = len(nums) - 1
            while (low <= high):
                mid = low + (high - low) // 2
                if nums[mid] == target:
                    idx = mid
                if nums[mid] >= target:
                    high = mid - 1
                else:
                    low = mid + 1
            return idx

        def searchRight(nums, target):
            idx = -1
            low = 0
            high = len(nums) - 1

            while (low <= high):
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