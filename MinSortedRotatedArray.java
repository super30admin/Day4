/**
Problem: find minimum in sorted rotated array
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 
Time Complexity : O(log n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        
        if (nums[0] < nums[nums.length - 1] || low == high) {
            return nums[0];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (mid + 1 <= nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[low] <= nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}