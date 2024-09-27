# Time Complexity: O(log(N)) when there are ony duplicates
# Space Complexity: O(1)
# Passed Leetcode
# Problems: When I reached the last value in the array, it went out of bounds initially

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        
        if len(nums) == 0:
            return -1
        
        if len(nums) == 1:
            return 0
        
        while left <= right:
            mid = left + (right - left) // 2
            
            if mid < len(nums) - 1 and nums[mid] < nums[mid + 1]:
                left = mid + 1
            else:
                if nums[mid - 1] < nums[mid]:
                    return mid
                right = mid - 1
                
