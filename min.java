// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        // check if the array is null or empty
        if(nums == null || nums.length == 0) return -1;
        // intialize low ang high pointers
        int low = 0;
        int high = nums.length - 1;
        // if the array is already sorted then return the first element of array
        if(nums[low] < nums[high]) return nums[low];
        // binary search
        while(low <= high){
            // find mid
            int mid = low + (high - low) / 2;
            // if the sub array is sorted, return the first element of array
            if(nums[low] < nums[high]) return nums[low];
            // check if mid is greater than its neighbors
            // also check for boundary conditions
            if((mid == 0 || nums[mid] < nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            } else if(nums[low] <= nums[mid]){
                //left side is sorted so move to right side
                low = mid + 1;
            } else {
                // right side is sorted so move to left side
                high = mid - 1;
            }
        }
        return -1;
    }
}