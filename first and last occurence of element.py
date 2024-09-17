class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        left = self.lower(nums, target)
        right = self.high(nums, target)
        if left == right:
            return [-1, -1]
        return [left, right]

    def lower(self, nums, target):
        l, h = 0, len(nums)
        while l < h:
            mid = l + (h - l) // 2
            # if nums[mid] == target:
            #     return mid
            if nums[mid] < target:
                l = mid + 1
            else:
                h = mid
        return l

    def high(self, nums, target):
        l = 0
        h = len(nums)
        while l < h:
            mid = l + (h - l) // 2

            # if nums[mid] == target:
            #     return mid
            if nums[mid] <= target:
                l = mid + 1
            else:
                h = mid - 1
        return l
