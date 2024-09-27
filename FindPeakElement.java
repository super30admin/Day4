// Time Complexity : O(log n) where n is the size of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (mid + 1 < nums.length && (nums[mid + 1] > nums[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}