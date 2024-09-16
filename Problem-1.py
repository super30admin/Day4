"""
Approach:
The goal is to find the boundary pointers of the required sub-array. We'd use binary search to find each of these
pointers.
1) if we find the target at mid, we look for the lower boundary of the required sub-array on the left partition
and the high boundary on the right partition
    a) the way binary search is conducted is handled separately on each partition

2) Ideally, we'd check the neighbors first when an element in the required sub-array is found and then go about
checking the partitions

"""


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        lo, hi = 0, len(nums) - 1

        if not nums or lo == hi and target != nums[lo]:
            return [-1, -1]
        else:
            lo = self.bs_l(lo, hi, target, nums)
            hi = self.bs_r(lo, hi, target, nums)
        return [lo, hi]

    def bs_l(self, lo, hi, target, nums):
        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] < target:
                    return (mid)
                else:
                    hi = mid - 1
            elif nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return -1

    def bs_r(self, lo, hi, target, nums):
        while lo <= hi:
            mid = lo + (hi - lo) // 2

            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid + 1] > target:
                    return (mid)
                else:
                    lo = mid + 1
            elif nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1
        return -1

"""
Time Complexity: O(log n)
Space Complexity: O(1) 
"""









