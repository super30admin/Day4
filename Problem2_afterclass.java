// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: Using binary search checked for mid element. If mid+1 element is lesser than mid then return mid+1. If mid<mid-1 return mid  else go for binary search

class Solution {
    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid + 1) <= nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if ((mid - 1) >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[low] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }
}