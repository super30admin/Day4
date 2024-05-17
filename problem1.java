/*
    LC - 34. Find First and Last Position of Element in Sorted Array
    TC - O(log n)
    SC - O(1)
    Approach - Using Binary search to find the first and last position separately.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int first = binarySearchFirst(nums, target);
        if(first == -1) {
            return new int[] {-1, -1};
        }
        int second = binarySearchSecond(nums, target);
        return new int[] {first, second}; 
    }
    private int binarySearchFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2; // to prevent integer overflow
            if(nums[mid] == target) {
                if(mid == low || nums[mid-1] != target) { 
                    return mid;
                }
                high = mid -1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
    private int binarySearchSecond(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2; // to prevent integer overflow
            if(nums[mid] == target) {
                if(mid == high || nums[mid+1] != target) {
                    return mid;
                }
                low = mid + 1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}