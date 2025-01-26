# Time complexity : O(log n)
# Space complexity : O(n)

class Solution:

    # def binarySearch():

    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        low = 0
        high = n-1
        start, end = -1, -1
        if n == 0 or nums[low] > target > nums[high]:
            return [start, end]
        if nums[low] == nums[high] == target:
            return [low, high]
        while(low <= high):
            mid = low + (high - low) // 2
            if (mid == 0 or nums[mid-1] != target) and nums[mid] == target:
                start = mid
                break
            if nums[mid] >= target:
                high = mid - 1
            else:
                low = mid + 1
        low = start
        high = n-1
        if nums[low] == nums[high] == target:
            return [low, high]
        while(low <= high):
            mid = low + (high - low) // 2
            if (mid == n-1 or nums[mid+1] != target) and nums[mid] == target:
                end = mid
                break
            if nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return [start, end]