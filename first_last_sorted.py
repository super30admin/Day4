"""
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
Algorithm Explanation
- We consider the binary search on two halves of the array
- Check for leftmost matching element index
    - compute mid 
    - if element at mid is equal to target, search for mid - 1 for the target if it exists
        - if mid is low or element at mid - 1 doesn't match the target, return mid
        - else update hi = mid - 1
    - Else continue the normal binary search while updating low and high pointers

- Check for rightmost matching element index
    - compute mid 
    - if element at mid is equal to target, search for mid + 1 for the target if it exists
        - if mid is high or element at mid + 1 doesn't match the target, return mid
        - else update lo = mid + 1
    - Else continue the normal binary search while updating low and high pointers
- Return the obtained left and right indexes as [left, right]
"""
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        """
        1. Call left Binary search with nums
        2. Call right Binary search with nums
        """
        
        def left_bs(nums,target):
            lo,hi = 0,len(nums) - 1
            while lo <= hi:
                mid = (lo + hi) // 2
                if nums[mid] == target:
                    if mid == lo or nums[mid - 1] != target:
                        return mid
                    else:
                        hi = mid - 1
                elif nums[mid] < target:
                    lo = mid + 1
                else:
                    hi = mid - 1
            return -1
        
        def right_bs(nums,target):
            lo,hi = 0,len(nums) - 1
            while lo <= hi:
                mid = (lo + hi) // 2
                if nums[mid] == target:
                    if mid == hi or nums[mid + 1] != target:
                        return mid
                    else:
                        lo = mid + 1
                elif nums[mid] < target:
                    lo = mid + 1
                else:
                    hi = mid - 1
            return -1
        
        return [left_bs(nums,target),right_bs(nums,target)]