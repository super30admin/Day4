//Time complexity is log(n)
class Solution {
    public int findPeakElement(int[] nums) {

        // going on the number greater than mid will always find a peak.

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // to prevent integer overflow

            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])) {
                // this is the happy case where the peak is found
                return mid;
            }

            // peak not yet found

            if (nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return 1234; // we can return anything
    }
}