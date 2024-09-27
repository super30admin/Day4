#162. Find Peak Element
"""
Time Complexity : O(log n)
Space Complexity : O(1)
Problem run in leetcode : Yes
Any Problem faced : No

Moving towards element having higher value.
Even if we reach to last element, it can be Peak Element as +infinite [1...n] -infinite condition is
given.
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        if len(nums) == 1:
            return low

        #checking the edge conditions.
        if nums[low] > nums[low + 1]:
            return low

        if nums[high - 1] < nums[high]:
            return high

        #binary search
        while low <= high:
            mid = low + (high - low) // 2

            #if both neighbours of mid are smaller then return mid
            if nums[mid] > nums[mid + 1] and nums[mid - 1] < nums[mid]:
                return mid

            #if right side have greater element, move access to RHS
            elif nums[mid] < nums[mid + 1]:  # and nums[mid-1] < nums[mid]:
                low = mid + 1

            #if left side have greater element, move access to LHS
            # elif nums[mid] > nums[mid+1] and nums[mid-1] > nums[mid]:
            else:
                high = mid - 1

        return False