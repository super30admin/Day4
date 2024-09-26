// Time complexity: O(log n) where n is the number of elements in the array.
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinInRotated {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            if(nums[low] <= nums[high]) return nums[low];   // If in a sorted manner, low is minimum.
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            else if(nums[mid] >= nums[low]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }           
        }
        return 123456;      // This never runs.
    }
}