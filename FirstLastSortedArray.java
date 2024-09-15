// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
class Solution {
    public int[] searchRange(int[] nums, int target) {

        if ( nums == null || nums.length == 0 ) return new int[] {-1, -1};
        if (target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};

        int first = binarySearchFirstOccurence(nums, target);
        if ( first == -1) {
            return new int[] {-1, -1};
        }

        int second = binarySearchLastOccurence(nums, target);

        return new int[] {first, second};
    }

    private static int binarySearchFirstOccurence(int[] nums, int target) {
        int mid;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            mid = low + (high-low)/2; // Handle OverFlow

            if (target == nums[mid]) {
                // Target found, check if its first occurence or not
                if (mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid;
                }
                high = mid - 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchLastOccurence(int[] nums, int target) {
        int mid;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            mid = low + (high-low)/2; // Handle overflow

            if (target == nums[mid]) {
                // Target found, check if last occurence or not
                if (mid == nums.length-1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                }
                low = mid + 1;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}