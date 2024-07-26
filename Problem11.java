// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Problem11 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search for a peak element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare middle element with its right neighbor
            if (nums[mid] < nums[mid + 1]) {
                // Peak must be in the right half
                left = mid + 1;
            } else {
                // Peak must be in the left half
                right = mid;
            }
        }

        // The left index will point to a peak element
        return left;
    }
}
