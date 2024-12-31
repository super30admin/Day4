// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Used two separate binary search functions: one to find the first position and
// another to find the last position of the target in the sorted array.

class SolutionFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, target);
        if(first == -1) {
            return new int[]{-1, -1};
        }
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid-1] != nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == high || nums[mid+1] != nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
