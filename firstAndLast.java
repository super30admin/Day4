// time complexity: O(log(n))
// space complexity: O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int firstOcc = binarySearchleft(nums, target);
        if (firstOcc == -1) {
            return new int[]{-1, -1};
        }
        int secondOcc = binarySearchRight(nums, target, firstOcc);
        
        return new int[]{firstOcc, secondOcc};
    }
    
    private int binarySearchleft(int nums[], int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                if (mid == low || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                high = mid - 1;
            } else {
                if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    private int binarySearchRight(int nums[], int target, int bound) {
        int low = bound;
        int n = nums.length;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                if (mid == high || nums[mid + 1] > nums[mid]) {
                    return mid;
                }
                low = mid + 1;
            } else {
                if (target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    
}