# Time Complexity : O(log N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if nums == None or len(nums) == 0:
            return [-1, -1]
        n = len(nums) - 1
        first = self.binarySearchFirst(nums, 0, n, target)
        if first == -1:
            return [-1, -1]
        last = self.binarySearchLast(nums, 0, n, target)
        return [first, last]

    def binarySearchFirst(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] < nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target :
                high = mid - 1
            else:
                low = mid + 1
        return -1
    
    def binarySearchLast(self, nums, low, high, target):
        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] == target:
                if mid == high or nums[mid + 1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target :
                high = mid - 1
            else:
                low = mid + 1
        return -1