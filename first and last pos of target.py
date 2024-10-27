class Solution:
    def binSearchFirst(self, nums, target, low, high):
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid] != nums[mid-1]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1

    def binSearchSecond(self, nums, target, low, high):
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == high or nums[mid] != nums[mid+1]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1         

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1

        if len(nums) == 0:
            return [-1, -1]
        first = self.binSearchFirst(nums, target, low, high)
        if first == -1:
            return [-1, -1]
        sec = self.binSearchSecond(nums, target, first, high)
        return [first, sec]
