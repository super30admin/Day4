//Time Complexity: O(logn)
//Space Complexity: O(1)
// Did this code run successfully on leetcode : yes

class Solution {
    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) { // only one element in the array
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid; // when the mid element is larger then its neighbors its the peak and consider
                            // the left side edge case.
            } else if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                // if mid+1 element is larger move to the right side considering the right side
                // edge case.
                low = mid + 1;
            } else {
                high = mid - 1; // else move to the left side.
            }
        }
        return -1;

    }
}