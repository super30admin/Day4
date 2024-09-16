// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution:
    
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            return 0 if nums[0] > nums[1] else 1
        low = 0
        high = len(nums) - 1
        
        while (low < high):
            mid = low + (high-low)//2
            if nums[mid] < nums[mid+1]:
                low = mid + 1
            else:
                high = mid 
        return low
            