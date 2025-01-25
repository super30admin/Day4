// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Binary search to find minimum in rotated sorted array

public class FindMinimum {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;

        while (low <= high) {
            // check if complete range is sorted
            if (nums[low] <= nums[high]) return nums[low];

            int mid = low + (high - low) / 2;
            // check if mid is the minimum
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == len - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                // when pivot lies on the right
                low = mid + 1;
            } else {
                // when pivot lies on the left
                high = mid - 1;
            }
        }
        // return garbage value
        return -1;
    }
}
