class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if target <= nums[mid]:
                r = mid - 1
            else:
                l = mid + 1
        if l < len(nums) and nums[l] == target:
            left = l
        else:
            return [-1, -1]

        l, r = 0, len(nums) - 1
        while l <= r:
            mid = l + (r - l) // 2
            if target >= nums[mid]:
                l = mid + 1
            else:
                r = mid - 1

        return [left, r]