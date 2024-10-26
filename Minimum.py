# Approach:
# We use binary search to find the minimum element in a rotated sorted array. 
# The key is to compare the middle element with the right boundary; if mid > right, 
# the minimum is in the right half; otherwise, it's in the left half. 
# This allows us to locate the minimum efficiently in O(log n) time.

# Time Complexity: O(log n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        
        while left < right:
            mid = (left + right) // 2
            
            # If mid element is greater than the right element, the min is in the right half.
            if nums[mid] > nums[right]:
                left = mid + 1
            # If mid element is smaller or equal to the right, min is in the left half (including mid).
            else:
                right = mid
        
        # At the end of the loop, left == right pointing to the minimum element.
        return nums[left]
