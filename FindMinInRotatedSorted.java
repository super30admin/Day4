// Time Complexity : o(log(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int findMin(int[] nums) {
        //check if it is not a rotated sorted array, then return nums[0]
        if(null == nums || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[high]) return nums[low];
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length -1 || nums[mid] < nums[mid +1])){
                return nums[mid];
            } else if(nums[low] <= nums[mid]){
                //left side is sorted
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
        
    }
}