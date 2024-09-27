class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        
        
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if mid - 1 < 0:
                if nums[mid] > nums[mid + 1]:
                    return mid
            if mid + 1 > len(nums) - 1:
                if nums[mid] > nums[mid - 1]:
                    return mid
            
            if nums[mid] > nums[mid - 1] and nums[mid] > nums[mid + 1]:
                return mid
            elif nums[mid] < nums[mid + 1]:
                left = mid + 1
            else:
                right = mid - 1
