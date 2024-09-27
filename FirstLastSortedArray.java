// Time Complexity : O(m + log n) where n is the size of the array, m is number of duplicates of target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                int forwardTemp = mid, backwardTemp = mid;
                while (forwardTemp - 1 > -1 && (nums[forwardTemp - 1] == nums[forwardTemp])) {
                    forwardTemp -= 1;
                }
                while (backwardTemp + 1 < nums.length && (nums[backwardTemp + 1] == nums[backwardTemp])) {
                    backwardTemp += 1;
                }
                return new int[] { forwardTemp, backwardTemp };
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[] { -1, -1 };
    }
}