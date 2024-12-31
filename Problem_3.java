// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Use binary search to move towards the direction where the adjacent element is greater,
// as there’s a higher probability of finding a peak in that direction.

class SolutionPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if((mid == low || (nums[mid] > nums[mid - 1])) && (mid == high || (nums[mid] > nums[mid + 1]))) {
                return mid;
            }
            if(nums[mid + 1] > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
