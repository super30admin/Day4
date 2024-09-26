"""
Problem: Find Peak Element. A peak element is an element that is greater than its neighbors.
Leetcode: https://leetcode.com/problems/find-peak-element/
Solution:
    - Use binary search,
    - Go to right if there's inclined slope
    - left if there's decline slope
Time Complexity: O(log n), where n is number if elements in given array
Space Complexity: O(1)
"""

class Solution:
    def findPeakElement(self, nums):
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = int(left + (right - left)/2)
            if nums[mid] < nums[mid+1]:
                left = mid + 1
            else:
                # right = mid instead of (mid - 1) because mid could be peak itself
                right = mid
        # return the index when left = right
        return left # or right

obj = Solution()
# Test Cases:
print(obj.findPeakElement([1,2,1,3,5,6,4]))
# print(obj.findPeakElement([1,5,1,3,2,4,3]))
# print(obj.findPeakElement([5,4,3,2,1]))
# print(obj.findPeakElement([1,2,3,4,5]))