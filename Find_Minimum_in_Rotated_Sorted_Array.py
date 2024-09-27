class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            if nums[left] <= nums[right]:
                return nums[left]
            if nums[mid] < nums[mid - 1] and nums[mid] < nums[mid + 1]:
                return nums[mid]
            else:
                if nums[left] <= nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
