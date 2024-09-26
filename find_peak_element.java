// Time Complexity : O(logn) ;(n is the no.of elements in array) 
// Space Complexity : O(1) ; no auxilary space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

public class find_peak_element {
    public int findPeakElement(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // avoiding integer overflow
            if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && // checking if mid element is the peak and also
                                                                         // including edge cases i.e. if mid is the
                                                                         // first or last element of the array
                    (mid == 0 || nums[mid - 1] < nums[mid])) {
                return mid;
            } else if (mid != nums.length - 1 && nums[mid + 1] > nums[mid]) { // if mid is not the last element and the
                                                                              // element next to mid is greater than mid
                                                                              // element so we will search in right side
                                                                              // of array
                low = mid + 1;
            } else {
                high = mid - 1; // if element at mid-1 is greater than mid , so we will search in the left side
                                // of array
            }
        }
        return 8899;
    }
}
