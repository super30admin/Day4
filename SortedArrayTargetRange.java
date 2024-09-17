/**
 * time complexity is O(logn)
 * space complexity is O(1)
 * leetcode test cases - pass
 */
public class SortedArrayTargetRange {
    public int[] searchRange(int[] nums, int target) {
        int targetIndex = bs(nums, target);
        if(targetIndex == -1) {
            return new int[] {-1, -1};
        }
        int leftIndex = bsl(nums, target, 0, targetIndex);
        int rightIndex = bsr(nums, target, targetIndex, nums.length-1);
        return new int[] {leftIndex, rightIndex};
    }
    
    private int bs(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    private int bsl(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(mid > 0 && nums[mid] == target && nums[mid-1] < target) {
                return mid;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return 0;
    }
    
    private int bsr(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(mid + 1 < nums.length && nums[mid] == target && nums[mid+1] > target) {
                return mid;
            }
            if(nums[mid] == target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return nums.length-1;
    }
}
