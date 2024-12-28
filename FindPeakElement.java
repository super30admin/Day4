/**
 * Time Complexity: O(logn) due to binary search.
 * Space Complexity: O(1), as no additional memory is used.
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : no
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if (high == low)
            return 0;

        // check if 0th index is peak
        if (nums[0] > nums[1])
            return 0;

        // check if n-1'th index is peak
        if (nums[high] > nums[high - 1])
            return high;

        // binary search and see if mid is greater than neighbors, if not, move left and right accordingly
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
