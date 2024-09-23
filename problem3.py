class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        
        while left < right:
            mid = (left + right) // 2
            
            if nums[mid] < nums[mid + 1]:
                # Peak is on the right side
                left = mid + 1
            else:
                # Peak is on this element or to the left
                right = mid
        
        # When left == right, we have found a peak element
        return left