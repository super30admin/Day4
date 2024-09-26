// Time complexity: O(log n) where n is the number of elements.
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TargetRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {      // Base case.
            return new int[] {-1, -1};
        }
        if(target < nums[0] || target > nums[nums.length - 1]) {    // Target value not in array.
            return new int[] {-1, -1};
        }
        int first = firstBinarySearch(nums, target);    // First occurrence index.
        if(first == -1) {                               // Not found.
            return new int[] {-1, -1};
        }
        int second = secondBinarySearch(nums, target);  // Second occurrence index.
        return new int[] {first, second};
    }
    
    // To find the first occurrence.
    private int firstBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid - 1]) {     // Check if the previous element is also the target or not.
                    return mid;
                }
                else {
                    high = mid - 1;  // Left index also has target, move left.
                }
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
    
    // Find the second occurrence. If only one target, it returns the first occurrence index.
    private int secondBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {   // Check if the right element is also the target or not.
                    return mid;
                }
                else {
                    low = mid + 1;  // Right index also has target, move right.
                }
            }
            else if(target < nums[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}