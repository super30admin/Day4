// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

Used binary search inorder to find the peak element in the array.

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if not nums:
            return -1
        low = 0
        high = len(nums)-1
        while low<=high:
            mid = (low+high)//2
            if low == high:
                return low
            
            if nums[mid]>nums[mid+1]:
                high = mid
            else:
                low = mid+1
        return -1