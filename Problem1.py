# Time Complexity: O(log n)
# Space Complexity: O(1)
# Leetcode all test cases passed: Yes
# Problems faced: Yes, not sure if changing left and right by 1 is optimal solution. Line 22-25

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        left = 0
        right = len(nums)-1
        
        while left <= right:
            
            mid = left + (right - left) // 2
            
            if nums[left] == target and nums[right] == target:         # Checking if both left and right indexes have target, if yes, return them
                return [left, right]
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:                                                       # if mid is target and left or right are not target number index
                if nums[left] != target:                                # Since this can be only possible for < 2 number of times, we can linearly increase left and decrease right
                    left += 1
                if nums[right] != target:
                    right -= 1
        return [-1,-1]
