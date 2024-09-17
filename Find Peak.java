// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // checking if mid is peak
            if ( (mid == 0 || nums[mid] > nums[mid-1] ) && (mid == nums.length - 1 || nums[mid] > nums[mid+1]) ) {
                return mid;
            }
            // if mid not peak and greater than left, we go right
            else if (mid == 0 || nums[mid] > nums[mid-1]) {
                start = mid + 1;
            }
            else {
                // go left
                end = mid - 1;
            }
        }
        return - 1;
    }
}