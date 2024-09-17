/* Leetcode : 153. Find Minimum in Rotated Sorted Array
* Time Complexity: O(Log N)
* Space Complexity: O(1)
* */
public class MinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        // Base conditon: nums is null or not
        if (nums.length == 1) {
            return nums[0];
        }
        // Returning first element if the array is sorted in the ascending order
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // Sorted Part, so returning the first element
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            int middle = low + (high - low) / 2; // Calculating the middle index

            if ((middle == 0 || nums[middle] < nums[middle - 1])

                    && (middle == nums.length - 1 || nums[middle] < nums[middle + 1])) {

                return nums[middle];
            } // Checking for the sorted part
            else if (nums[low] <= nums[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
