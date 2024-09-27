// Time Complexity : O(logn) where n is the length of the nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class firstLastPositionsInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = binarySearchFirst(nums, target);
        ans[1] = binarySearchSecond(nums, target);
        return ans;
    }
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == low || nums[mid] > nums[mid - 1]) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    private int binarySearchSecond(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == high || nums[mid] < nums[mid + 1]) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}