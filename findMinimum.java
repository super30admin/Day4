// Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        if (nums.length == 1)
            return nums[0];
        if (nums[0] < nums[high])
            return nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            // Check Left Side
            if (nums[high] > nums[mid])
                high = mid;
            else
                // Check right side
                low = mid + 1;
        }
        return nums[high];
    }
}