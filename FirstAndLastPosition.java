// Time Complexity :O log(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };

        if (target < nums[0] && target > nums[nums.length - 1])
            return new int[] { -1, -1 };

        int first = findFirstIdx(nums, target);

        if (first == -1) {
            return new int[] { -1, -1 };
        }

        int last = findLastIdx(nums, target);

        return new int[]{first, last};
    }

    private int findFirstIdx(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;// means we have not yet found 1st element,keep going left
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

       private int findLastIdx(int[] nums, int target) {
         int low = 0, high = nums.length -1;

        while (low <= high) {
             int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length -1 || nums[mid + 1] != nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;// means we have not yet found last element,keep going right
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}