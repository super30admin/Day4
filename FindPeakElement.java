// Time complexity: O(log n) where n is the number of elements in the array.
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {      // Testing base case.
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;       // Integer overflow.
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 ||nums[mid] > nums[mid + 1])) {
                return mid;
            }
            else if(mid != 0 && nums[mid] < nums[mid - 1]) {    // Move to the left side.
                high = mid - 1;
            }
            else {      // Move to the right side.
                low = mid + 1;
            }
        }
        return 123456;      // This never runs because a peak is always found.
    }
}