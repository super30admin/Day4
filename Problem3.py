# Time Complexity : O(logn)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, couldn't think of it as binary. Loved the approach though!
# Your code here along with comments explaining your approach
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2
            # ascending slope move to right 
            if nums[mid] < nums[mid+1]:
                left = mid +1
            # descending slope move to the left
            else:
                right = mid
        print(left, right)
        return left
