// Time Complexity : O(log n) //We do 2 binary searches one after the other so O(log n) + O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ret = new int[2];

        if(nums == null || nums.length == 0)
            return new int[]{-1,-1};

        if(nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1,-1};

        ret[0] = binarySearchLeft(nums, target);
        ret[1] = binarySearchRight(nums, target);

        return ret;

    }

    public int binarySearchLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if(mid == 0 || nums[mid -1] < nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                if(mid == nums.length -1 || nums[mid + 1] > nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
