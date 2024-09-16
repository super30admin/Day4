"""
Approach:
1) Using binary search find the pivot element
2) if the mid element is lesser than its neighbors, it's the pivot element

"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        lo = 0
        hi = len(nums) - 1

        while (lo <= hi):
            if nums[lo] < nums[hi]: return nums[lo]  # array is sorted already
            mid = lo + (hi - lo) // 2

            # found pivot
            if (mid == 0 or nums[mid] < nums[mid - 1]) \
                    and (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]):
                return nums[mid]

            elif nums[lo] <= nums[mid]:  # low and mid could be same
                lo = mid + 1

            else:
                hi = mid - 1


"""
Time Complexity: O(log n)
Space Complexity: O(1)
"""