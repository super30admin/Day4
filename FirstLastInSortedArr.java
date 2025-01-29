// Using binary search to identify the high and low for the ocuurences.
// Time complexity of O(logn)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int leftIdx = -1;
        int rightIdx = -1;

        // Find the first occurrence of the target
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        if(low >= nums.length || nums[low] != target) {
            return new int[]{-1, -1};
        }

        leftIdx = low;

        // Reset the pointers for finding the last occurrence
        low = 0;
        high = nums.length - 1;

        // Find the last occurrence of the target
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        rightIdx = high;

        return new int[]{leftIdx, rightIdx};
    }
}