"""
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
- In order to find the peak, we need to determine a position such that ele at 
pos > ele at pos - 1 and ele > ele at pos + 1
- Running a binary search as follows
    - Compute mid
    - if ele at mid < ele at mid + 1, clearly indicates peak is in right side of the mid
        - lo = mid + 1
    - else peak is in the left side of mid
        - hi = mid
    - Run the above steps until hi bypasses low
"""
class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        lo,hi = 0,len(nums) - 1
        mid = (lo + hi) // 2
        while lo < hi:
            mid = (lo + hi) // 2
            if nums[mid] < nums[mid+1]:
                lo = mid + 1
            else:
                hi = mid
        return lo