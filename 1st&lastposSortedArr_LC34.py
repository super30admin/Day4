# Leetcode submission successful
# 2 Binary Searches to be performed, one for first occurrence and one for last occurrence.
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # logarithmic time so binary search. Time Complexity: O(2log(n)) which can be considered O(log n)
        # Space Complexity: O(1)

        # First search for first occurrence.
        lo = 0
        hi = len(nums) - 1

        flag = False
        while (lo <= hi):
            mid = lo + (hi - lo) / 2  # to prevent integer overflow
            if target == nums[mid]:
                if nums[mid] > nums[mid - 1] or mid == 0:   # if target is found at index 0 it has to be the first occurrence.
                    first_occ = mid
                    flag = True
                    break
                hi = mid - 1  # to find first occurrence
            if target > nums[mid]:
                lo = mid + 1
            if target < nums[mid]:
                hi = mid - 1
        if flag == False:   # if element is not found at all, there is no point in finding last occurrence.
            return [-1, -1]

        # Second search for last occurrence.
        lo = 0
        hi = len(nums) - 1

        while (lo <= hi):
            mid = lo + (hi - lo) / 2  # to prevent integer overflow
            if target == nums[mid]:
                # if target is found at last index, it has to be the last occurrence.
                if ((mid == (len(nums) - 1) or nums[mid] < nums[mid + 1])):  # order matters
                    last_occ = mid
                    break
                lo = mid + 1  # to find last occurrence
            if target > nums[mid]:
                lo = mid + 1
            if target < nums[mid]:
                hi = mid - 1

        return [first_occ, last_occ]