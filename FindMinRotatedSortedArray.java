// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * The idea is to apply binary search and divide the serarch space into half based on a check.
 * If the right part is sorted from range [mid, high], we will not find a minimum element there, so we search left
 * If it is not sorted, we will find the minimum on right side as rotation point will be there.
 */

class Solution {
    public int findMin(int[] nums) {
        // base case
        if (nums.length == 1) {
            return nums[0];
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            
            if (low == high) {
                // can be only the first element
                return nums[0];
            }
            
            int mid = low + (high - low) / 2;
            
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                // minimum found at mid + 1
                return nums[mid + 1];
            } else if (nums[high] > nums[mid]) {
                // right part is sorted, we won't find minimum here
                // move left
                high = mid;
            } else {
                // left part should be sorted, we won't find the minimum there
                // move right
                low = mid;
            }
        }
        
        // In case we did not found the minimum, it should be the first element at the first index
        return nums[0];
    }
}