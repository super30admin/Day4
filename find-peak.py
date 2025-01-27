'''
Time complexity: O(log n)
Space complexity: O(1)
Leetcode: 162. Find Peak Element
Approach: Binary search to find the peak element by checking edge cases and performing binary search to compare mid elements with their neighbors.
Here we are finding any one peak element, not all peak elements or the first/maximum peak element.
'''


from typing import List

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        if high==0:
            return 0

        if nums[1] < nums[0]:
            return 0

        if nums[high] > nums[high-1]:
            return high

        while low <= high:
            mid = (low + high) // 2
            if nums[mid-1] < nums[mid] > nums[mid+1]:
                return mid
            elif nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    
# Test cases
nums = [1,2,3,1]
print(Solution().findPeakElement(nums)) # Output: 2
                