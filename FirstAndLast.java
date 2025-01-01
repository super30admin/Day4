/*
 * TC - O ( log n )
 * SC = O (1)
 * Locate the first occurrence using binary search until we hit a point where we are at the 'edge' of the targets (i.e. first element of the array or the point where arr[i] > arr[i - 1])
 * then locate the last occurrence by searching the array until we reach the last edge.
 * return {first, last}
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int first = binarySearchFirst(nums, target);
        if (first == -1) return new int[] {-1, -1};
        int last = binarySearchLast(nums, target);
        return new int[] { first, last };                                                                                                                                                  
    }
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                    return mid;
                }
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
