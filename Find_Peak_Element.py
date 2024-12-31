# Time Complexity = O(logn)
# Space Complexity = O(1)
# Leetcode = yes
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l, r = 0, len(nums)-1
        while l <= r:
            mid = l + (( r-l) // 2)
            # as we have greater element on mid - 1 position we can find peak at left side
            if nums[mid-1] > nums[mid] and mid > 0 :
                r = mid - 1
            # as mid+1 > mid we can find peak at right side of mid 
            elif mid < len(nums)-1 and nums[mid] < nums[mid +1]:
                l = mid + 1
            else:
                return mid
