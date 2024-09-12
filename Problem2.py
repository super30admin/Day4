# Time Complexity: O(log(n))
# Space Complexity: O(nums)
# Did this code successfully run on Leetcode: all test cases passed on Leetcode
# Any problem you faced while coding this: No

# Search until the stopping condition is found. Check if the minimum is on the right/ left hand of the array.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left, right = 0, len(nums)-1
        
        minValue = float('inf')
        
        while left <= right:
            
            mid = left + (right - left) // 2
            
            if nums[mid] <= nums[-1]:
                minValue = nums[mid]
                right = mid - 1
            
            else:
                left = mid + 1
                
        return minValue
