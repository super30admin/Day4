// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[high]) { // checking sorted array
                return nums[low];
            } else if ((mid == 0 || nums[mid] < nums[mid - 1]) && (nums[mid] < nums[mid + 1])) {
                return nums[mid]; // checking left and right of mid to determine if mid is min;
            } else if (nums[low] <= nums[mid]) { // move the search to unsorted range;

                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return 8585;
    }
}