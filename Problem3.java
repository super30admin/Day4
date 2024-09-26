// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * I am using Binary search to search for the peak element in this solution.
 * The approach is that whenever we find a mid element in binary search, we check if that is a peak element.
 * If the mid element is not a peak element, we make a decision to always move towards the greater element as we want to go towards bigger number to find the peak.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            

            if((mid == high || nums[mid] > nums[mid+1]) && (mid == 0 || nums[mid] > nums[mid-1])) {
                // Peak element found
                return mid;
            } else if (nums[mid] < nums[mid+1]) {
                // we move to the right half as next right element to mid index is greater
                low = mid + 1;
            } else {
                // we move to the left half as next right element to mid index is not greater
                high = mid - 1;
            }
        }
        
        return -1;
    }
}