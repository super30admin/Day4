// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MinimumRotatedArraySolution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        //If array has just one element
        if (nums.length == 1) {
            return nums[0];
        }

        // initializing low and high pointers.
        int low = 0; 
        int high = nums.length - 1;

        if (nums[high] > nums[0]) {
            return nums[0];
        }

        // Binary search way
        while (high >= low) {
            // Find the mid element
            int mid = low + (high - low) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // if the mid elements value is greater than the 0th element this means he least value is still somewhere to the right
            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
