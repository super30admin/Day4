// Time Complexity : O(log n) where n is the size of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (nums[low] <= nums[high]) {
                return nums[low];
            } else if (nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}