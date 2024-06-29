/**
 * Time Complexity: O(log N)
 * Space Complexity: O(1)
 */
class Solution {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        // Special case: if there's only one element, return its index
        if (nums.length == 1) {
            return 0;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if the mid element is a peak element
            if (mid > 0 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // If mid element is less than the next element, move to the right half
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // Otherwise, move to the left half
                high = mid - 1;
            }
        }

        // When low == high, we have found a peak element
        return low;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 1};
        int peakIndex = sol.findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}
