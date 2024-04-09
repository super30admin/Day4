// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// ex: [4,5,6,7,1,2,3] -> In, rotated sorted array, min value is always less than its left and right neighbors
class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length -1;

        while(low <= high) {
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + ( high -low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == high || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            if( nums[low] <= nums[mid]) {
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}