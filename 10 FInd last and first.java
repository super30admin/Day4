
// Time Complexity : O(logn)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[] { -1, -1 };
        
        int n = nums.length - 1;

        int first = findFirst(nums, 0, n, target);
        int last = findLast(nums, first, n, target);
        if (first == -1)
            return new int[] {-1,-1};

        return new int[] { first, last};
    }

    private int findFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] < target) {
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



    private int findLast(int[] nums, int low, int high, int target) {

        while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            if (mid == high || nums[mid + 1] > target) {
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