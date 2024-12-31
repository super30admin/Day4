// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Use binary search to repeatedly narrow the range to the unsorted half until
// the minimum element is found.

class SolutionRotatedSorted {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            if(nums[low] <= nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if(((mid == low) || (nums[mid] < nums[mid - 1])) &&
                    ((mid == high) || (nums[mid] < nums[mid + 1]))) {
                return nums[mid];
            }
            if(nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
