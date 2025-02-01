# The algorithm uses binary search to find the minimum element in a rotated sorted array by checking midpoints for abrupt drops, 
# indicating the pivot. It narrows the search space based on comparisons with the first element to efficiently locate the smallest
#  value.

# Time: O(log N) | Space: O(1).
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        begin = 0
        end = len(nums) - 1
        if nums[end] > nums[0]:
            return nums[0]

        while begin <= end:
            mid = begin + (end - begin) // 2
            if nums[mid] > nums[mid + 1]:
                  return nums[mid + 1]
            if nums[mid] < nums[mid - 1]:
                return nums[mid]
            if nums[mid] > nums[0]:
                begin = mid + 1
            else:
                end = mid - 1