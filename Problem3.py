# Time Complexity: O(N)
# Spacr Complexity: O(1)
# Leetcode all test cases passed: Yes
# Any difficulty: No

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left = 0                                
        right = len(nums)-1
        while left < right:
            mid = left + (right - left) // 2    
            if nums[mid] < nums[mid+1]:             #  if mid is less than the next element on right, it cannot be peak element, therefore there lies a peak on the right 
                left = mid + 1
            else:
                right = mid
        return left
                
                
