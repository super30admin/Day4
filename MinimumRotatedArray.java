// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] < nums[high]) return nums[low];
            int mid = (low + high) / 2;
            if (nums[mid] >= nums[low]) low = mid + 1;
            else if (nums[mid] < nums[high]) high = mid;
        }
        return nums[low];
}