// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = lowerRange(nums, target);
        int r = higherRange(nums, target);
        return new int[] {l, r};
    }
    public int lowerRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, x = -1;
        while(left <= right) {
            int mid = left + ((right - left) / 2);
            if(nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if(nums[mid] == target)
                x = mid;
        }
        return x;
    }
    public int higherRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1, x = -1;
        while(left <= right) {
            int mid = left + ((right - left) / 2);
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if(nums[mid] == target) {
                x = mid;
            }
        }
        return x;
    }
}