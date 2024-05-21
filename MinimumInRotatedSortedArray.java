// Time Complexity : o(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;

        while(low <= high){

            // Assuming a fully sorted array.
            if(nums[low] <= nums[high]){
                return nums[low];
            }
            int mid = low + (high - low)/2; // prevent integer overflow

            // Assuming min element is in the middle position of array.
            if((mid == low || nums[mid-1] > nums[mid]) && (mid == high || nums[mid+1] > nums[mid])){
                return nums[mid];
            }

            // Assuming left side of array is sorted and right side of array is unsorted and min element is on the unsorted side.
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }

            // Assuming right side of array is sorted and left side of array is unsorted and min element is on the unsorted side.

            else{
                high = mid -1;
            }
        }

        return -1;

    }
}