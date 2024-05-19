/*
    LC - 153. Find Minimum in Rotated Sorted Array
    TC - O(log n)
    SC - O(1)
    Approach - Using Binary search to find the minimum in rotated sorted array. Observation is in most of the case, if one half of array is sorted then always, target lies in the unsorted.
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while(low <= high){
            if(nums[low]<=nums[high]) {
                return nums[low];
            }
            int mid = low + (high - low) / 2; // to prevent integer overflow
            if((mid == low || nums[mid-1] > nums[mid]) && (mid == high || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            if(nums[low]<=nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 5430;
    }
}