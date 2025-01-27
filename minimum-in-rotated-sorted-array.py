'''
Time complexity: O(log n)
Space complexity: O(1)
LeetCode: Accepted, #153
Approach: Binary search
If the array is already sorted, return the 1st element.
If the array is rotated, find the mid element, If the mid element is the minimum element - if it is less than the adjacent elements - return it.
If the mid element is greater than the 1st element, search in the right half. If the mid element is less than the 1st element, search in the left half.
'''
from typing import List

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1

        while low <= high:
            if nums[low] <= nums[high]:
                return nums[low]
            
            mid = (low + high)//2
            if (mid == 0 or (nums[mid] < nums[mid-1])) and (mid == high or (nums[mid] < nums[mid+1])):
                return nums[mid]
            elif nums[low] <= nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        
        return -1
    

# Driver code
nums = [3,4,5,1,2]
print(Solution().findMin(nums)) # Expected 1