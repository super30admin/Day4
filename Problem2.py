# Time Complexity: O(N)
# Spacr Complexity: O(1)
# Leetcode all test cases passed: Yes
# Any difficulty: No

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums) - 1
        
        while left < right:
            mid = left + (right - left) // 2
            if nums[mid] > nums[right]:             # Checking if there lies a pivot on the right side of mid
                left = mid + 1                      # if yes, change left to mid + 1
            else:
                right = mid                         # If no, change right to mid
        return nums[left]
