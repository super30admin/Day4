"""
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had some back and forth in trying to 
set the low and high

// Your code here along with comments explaining your approach
Algorithm Explanation
[5,0,2,3,4] -> 
    rotated sorted
[5,6,7,8,0,2,3,4] - mid > high -> that means you have to search in right side, since lower elements wiil be
        towards right
[5,0,2,3,4] - mid < low -> that means you have to search in left side (because rigth side of element will be in 
        increasing order now)
        towards left
[0,1,2,3,4,5,6] -> sorted array -> return low
[5,6,7,0,1,2,3] -> ele at mid < ele at mid - 1 and ele at mid < ele at mid + 1 -> return ele at mid
"""
class Solution:
    def findMin(self, nums: List[int]) -> int:
        """
        [5,0,2,3,4] -> rotated sorted
        [5,6,7,8,0,2,3,4] - mid > high -> that means you have to search in right side, since lower elements wiil be
                towards right
        [5,0,2,3,4] - mid < low -> that means you have to search in left side (because rigth side of element will be in 
                increasing order now)
                towards left
        [0,1,2,3,4,5,6] -> sorted array -> return low
        """
        
        lo,hi = 0,len(nums) - 1
        while lo < hi:
            mid = (lo + hi) // 2
            if (mid == 0 or nums[mid] < nums[mid-1]) and nums[mid] < nums[mid+1]:
                return nums[mid]
            # if nums[lo] < nums[hi]:
            #     return nums[lo]
            elif nums[mid] > nums[hi]:
                lo = mid + 1
            else:
                hi = mid - 1
        
        return nums[lo]