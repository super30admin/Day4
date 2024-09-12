// Time Complexity : O(log n) where n in size of input array nums
// Space Complexity : O(1) as we did not use any auxiliary space/data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindPeakElement {
    public int findPeakElement(int[] nums) {

        // null check
        if ( nums == null || nums.length == 0 ) {
            return -1;
        }

        int low = 0;
        int high = nums.length-1 ;

        while ( low <= high ) {

            // find mid element
            int mid = low + (high-low) / 2;

            // check if mid is peak
            if  ( ( mid == 0 || nums[mid] > nums[mid-1] ) && ( mid == nums.length-1 || nums[mid] > nums[mid+1] ) ) {
                return mid;
            }
            else if (mid > 0 && nums[mid-1] > nums[mid]) { // check if left side is greater
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
