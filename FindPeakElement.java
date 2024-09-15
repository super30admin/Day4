// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Peak is defined as an element that is greater than it's immediate neighbor's. This peak can be found at 3 locations.
 *      a. In the middle of the array    - peak should be greater than left and right neighbors.
 *      b. At the beginning of the array - peak should be greater than the right neighbor.
 *      c. At the end of the array       - peak should be greater than the left neighbor.
 * 2. Perform binary search to find the peak as per the above definitions.
 * 3. If the middle element is not a peak, then we can traverse either to left or to the right.
*/
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {

        // Invalid conditions
        if (nums == null || nums.length == 0) return -1;

        // Only if one element is present in the array.
        if (nums.length == 1) return 0;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println(findPeakElement(new int[]{1,2,3}));
        System.out.println(findPeakElement(new int[]{3,2,1}));
    }
}
