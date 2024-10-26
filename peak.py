# The code defines a findPeakElement method to find a peak element in a list of integers using binary search.
# A peak element is defined as an element that is greater than its neighbors. The goal is to return the index of any peak element.
# 
# Two pointers, 'left' and 'right', are used to represent the search boundaries of the array.
# 
# In each iteration:
#   - The mid-point (mid) is calculated as (left + right) // 2.
#   - If nums[mid] is greater than nums[mid + 1], it means the peak lies in the left half or at 'mid' itself.
#       - Therefore, we adjust the search space by setting right = mid.
#   - Otherwise, the peak must lie in the right half, so we set left = mid + 1.
# 
# The loop continues until 'left' equals 'right', at which point the index of the peak element is found, and 'left' is returned.
# 
# TC: O(log n) - The time complexity is logarithmic as the search space is halved in each iteration.
# SC: O(1) - Constant space is used since only pointers for the search boundaries are maintained.


class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1

        return left