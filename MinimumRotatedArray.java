// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Find the sorted part in the array and then search for minimum using binary search in another part of the array
class MinimumRotatedArray {
    public int findMin(int[] nums) {
        int low = 0,high = nums.length - 1;
        while(low <= high) {
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == high || nums[mid] < nums[mid+1])) return nums[mid];
            else if(nums[mid] >= nums[low]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }
}