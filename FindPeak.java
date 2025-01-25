// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Binary Search to find the peak

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // check if mid is peak
            if ((mid == 0 || nums[mid] > nums[mid - 1])
                    && (mid == length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                // move in the direction of the peak and reject the other half
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return garbage value
        return -1;
    }
}
