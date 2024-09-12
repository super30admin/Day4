// 34. Find First and Last Position of Element in Sorted Array - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null)    // array has no elements
        {
            return (new int[] {-1, -1});
        }
        int left = 0, right = nums.length - 1;
        int foundAt = -1;                      // target value
        int mid = left + (right-left) / 2; 
        while (left <= right) 
        {
            mid = left + (right-left) / 2;
            if (nums[mid] == target) 
            {
                foundAt = mid;
                break;        // to find the position of the other index of target 
            } 
            else 
            {
                if (nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        if (nums[mid] != target) 
        {
            return (new int[] {-1, -1});
        }
        int l = mid, r = mid;                    
        while (l > 0 && nums[l - 1] == target) l--;                // has check to avoid NullPointerException - cause mid value might be 1st index so can not decrement l 
        while (r < nums.length - 1 && nums[r + 1] == target) r++;  // has check to avoid NullPointerException - cause mid value might be last index so can not increment r
        return (new int[] {l, r});
    }
}