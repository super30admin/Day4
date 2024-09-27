// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class FindPeak {
    public int findPeakElement(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2; 
            if ((mid == nums.length - 1 || nums[mid] > nums[mid + 1]) && 
            
                    (mid == 0 || nums[mid - 1] < nums[mid])) {
                return mid;
            } else if (mid != nums.length - 1 && nums[mid + 1] > nums[mid]) { 

                low = mid + 1;
            } else {
                high = mid - 1; 

            }
        }
        return -1;
    }
}