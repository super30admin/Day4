// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
 * The idea is to apply binary search in the array based on the check on which side of the pivot, we will definitely find a peak element.
 * if we see that mid+1 is greater than mid element, we will find a peak 100% on the right side, else we look for the peak on left side of the pivot (mid)
 */

class Solution {
    public int findPeakElement(int[] nums) {
        // base case
        if (nums.length == 1) {
            return 0;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < nums.length && mid - 1 >= 0 && nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (mid + 1 < nums.length && nums[mid+1] > nums[mid]) {
                // we will definitely find a peak in the right side.
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }
}