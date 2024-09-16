# Time Complexity O(logn)
# Space Complexity O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        if len(nums) == 1:
            return nums[0]
        if nums[left] <= nums[right]:
            return nums[left]
        while left <= right:
            mid = left + (right - left) // 2

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            if nums[mid - 1] > nums[mid]:
                return nums[mid]

            if nums[left] < nums[mid]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid - 1