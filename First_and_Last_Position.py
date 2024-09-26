class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        low = 0
        high = len(nums) - 1
        first = -1
        last = -1
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                first = mid
            if nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                last = mid
            if nums[mid] <= target:
                low = mid+1
            else:
                high = mid-1
        return [first,last]