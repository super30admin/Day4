# Approach:
# We use a binary search to find a peak element. At each step, we compare the middle element with its right neighbor; 
# if the middle element is smaller, a peak must exist on the right half, otherwise, it exists on the left half. 
# This approach guarantees an O(log n) runtime by dividing the search space in half at each step.

# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        
        while left < right:
            mid = (left + right) // 2
            
            # If the middle element is smaller than the next element, 
            # a peak exists in the right half.
            if nums[mid] < nums[mid + 1]:
                left = mid + 1
            # Otherwise, a peak exists in the left half (including mid).
            else:
                right = mid
        
        # At the end of the loop, left == right and it points to a peak element.
        return left
