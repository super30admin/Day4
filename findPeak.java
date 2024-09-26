// Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// Your code here along with comments explaining your approach
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}