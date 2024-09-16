// Time Complexity : O(2logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        if (target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};

        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);

        return new int[]{first, last};

    }
    private int binarySearchFirst(int nums[], int target) {
        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid]== target) {
                if (mid == 0 || nums[mid] > nums[mid - 1]) return mid;
                else h = mid - 1;
            }
            else if (nums[mid] > target) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
    private int binarySearchLast(int nums[], int target) {
        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid]== target) {
                if (mid == nums.length - 1 || nums[mid] < nums[mid + 1]) return mid;
                else l = mid + 1;
            }
            else if (nums[mid] > target) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}