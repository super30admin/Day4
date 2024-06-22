class Solution(object):
    def searchRange(self, nums, target):
        first = self.firstOcc(nums, target)
        if first == -1:
            return [-1, -1]
        last = self.lastOcc(nums, target)
        return [first, last]

    def firstOcc(self, nums, target):    
        low = 0
        high = len(nums) - 1
        first = -1
        while low <= high:
            mid = (low + (high - low) // 2)
            if nums[mid] == target:
                first = mid
                high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return first
    
    def lastOcc(self, nums, target):
        low = 0
        high = len(nums) - 1
        last = -1
        while low <= high:
            mid = (low + (high - low) // 2)
            if nums[mid] == target:
                last = mid
                low = mid + 1
            elif nums[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return last